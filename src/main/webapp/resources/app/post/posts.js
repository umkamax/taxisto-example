angular.module('taxisto.posts', [
    'ui.router',
    'ui.bootstrap'
])
.config(['$stateProvider', function($stateProvider) {
    $stateProvider
        .state('list', {
            url: '/posts',
            views: {
                '': {
                    templateUrl: 'resources/app/post/post.list.html',
                    controller: 'PostController'
                }
            }
        })
        .state('detail', {
            url: '/posts/:postId',
            views: {
                '': {
                    templateUrl: 'resources/app/post/post.detail.html',
                    controller: 'PostDetailController'
                }
            }
        })
}])
.factory('posts', ['$http', function($http) {
    var BASE_URL = '/post';

    var factory = {};
    factory.count = function() {
        return $http.get(BASE_URL + '/count').then(
            function(response) {
                return response.data;
            }
        )
    };
    factory.list = function(offset, maxResults) {
        return $http.get(BASE_URL, {params: {offset: offset, maxResults: maxResults}}).then(
            function(response) {
                return response.data;
            }
        )
    };
    factory.get = function(id) {
        return $http.get(BASE_URL + '/' + id).then(
            function(response) {
                return response.data;
            }
        )
    };
    factory.add = function(post) {
        return $http.post(BASE_URL, post).then(
            function(response) {
                return response.data;
            },
            function(error) {
                console.log(error);
            }
        )
    };
    return factory;
}])
.controller('PostController', ['$scope', 'posts', function($scope, posts) {
    //$scope.totalItems = -1;
    $scope.itemsPerPage = 2;
    $scope.currentPage = 1;

    //$scope.isShowPager = false;
    $scope.count = function() {
        posts.count().then( // to PagerController
            function(count) {
                $scope.totalItems = count;
                $scope.isShowPager = $scope.totalItems > $scope.itemsPerPage;
            }
        );
    };

    $scope.refresh = function() {
        var offset = ($scope.currentPage - 1) * $scope.itemsPerPage;
        var maxResults = $scope.itemsPerPage;
        posts.list(offset, maxResults).then(
            function(postsData) {
                $scope.count();
                $scope.posts = postsData;
            }
        );
    };

    $scope.newPost = {};
    $scope.add = function() {
        $scope.newPost.author = 'admin';
        $scope.newPost.date = moment().format("DD.MM.YYYY HH:mm:ss");
        posts.add($scope.newPost).then(
            function(postData) {
                $scope.newPost = {};
                $scope.refresh();
            }
        );
    };
    $scope.refresh();
}])
.controller('PostDetailController', ['$scope', '$stateParams', 'posts', function($scope, $stateParams, posts) {
    $scope.post = {};
    posts.get($stateParams.postId).then(
        function(postData) {
            $scope.post = postData;
        }
    );
}]);