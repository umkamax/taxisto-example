'use strict';

var app = angular.module('taxisto', []);

app.config(function($httpProvider) {
    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
});

app.factory('Post', function($http) {
    var BASE_URL = '/post';
    return {
        list: function() {
            return $http.get(BASE_URL);
        },
        add: function(post) {
            return $http.post(BASE_URL, post);
        }
    };
});

app.controller('PostController', function($scope, $timeout, Post) {

    $scope.refresh = function() {
        Post.list().then(
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
                $scope.posts.push(response.data);
                $scope.newPost = {};
            }
        );
    };

    $scope.refresh();
});