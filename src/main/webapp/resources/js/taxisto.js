'use strict';

var app = angular.module('taxisto', ['ui.bootstrap']);

app.config(function($httpProvider) {
    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
});

app.factory('Post', function($http) {
    var BASE_URL = '/post';
    return {
        count: function() {
            return $http.get(BASE_URL + "/count");
        },
        list: function(offset, maxResults) {
            return $http.get(BASE_URL, {params: {offset: offset, maxResults: maxResults}});
        },
        add: function(post) {
            return $http.post(BASE_URL, post);
        }
    };
});

app.controller('PostController', function($scope, Post) {


    $scope.totalItems = -1;
    $scope.itemsPerPage = 2;
    $scope.currentPage = 1;
    $scope.isShowPager = false;

    $scope.$watch('currentPage', function() {
        console.log('current page is: ' + $scope.currentPage);
        $scope.refresh();
    });

    Post.count().then(
        function(response) {
            $scope.totalItems = response.data;
            $scope.isShowPager = $scope.totalItems > $scope.itemsPerPage;
        }
    );

    $scope.refresh = function() {
        var offset = ($scope.currentPage - 1) * $scope.itemsPerPage;
        var maxResults = $scope.itemsPerPage;
        Post.list(offset, maxResults).then(
            function(response) {
                $scope.posts = response.data;
            }
        );
    };

    $scope.newPost = {};
    $scope.add = function() {
        $scope.newPost.author = 'admin';
        $scope.newPost.date = moment().format("DD.MM.YYYY HH:mm:ss");
        Post.add($scope.newPost).then(
            function(response) {
                $scope.posts.unshift(response.data);
                $scope.posts.pop();
                $scope.newPost = {};
            }
        );
    };

    //$scope.refresh();
});