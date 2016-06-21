angular.module('taxisto.users', ['ui.router'])
.config(['$stateProvider', function($stateProvider) {
    $stateProvider
        .state('login', {
            url: '/login',
            views: {
                '': {
                    templateUrl: '/resources/app/user/login.html',
                    controller: 'LoginController'
                }
            }
        });
}])
.factory('users', ['$http', function($http) {
    var factory = {};
    factory.login = function(username, password) {
        var user = {};
        user.username = username;
        user.password = password;
        return $http.post('/user', user).then(
            function(response) {
                console.log(response);
                localStorage.setItem('currentUser', JSON.stringify(response.data));
            },
            function(error) {
                console.log(error);
            }
        )
    };
    return factory;
}])
.controller('LoginController', ['$scope', '$state', 'users', function($scope, $state, users) {
    $scope.login = function() {
        users.login($scope.username, $scope.password).then(
            function(data) {
                // $state.go('list');
                console.log(data);
            }
        )
    }
}])