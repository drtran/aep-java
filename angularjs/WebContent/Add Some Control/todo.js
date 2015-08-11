/**
*
*/
function TodoCtrl($scope) {
	$scope.todos = [
	  {text:'learn angular', done:true},
	  {text:'build on angular app', done:false},
	  {text: 'A NEW Angular TO DO', done:true},
	];
	
	$scope.addTodo = function() {
		$scope.todos.push({text:$scope.todoText, done:false});
		$scope.todoText = 'Default Text After a new Todo';
		$scope.message = "$scope.addTodo was called";
	};
	
	$scope.remaining = function() {
		var count = 0;
		angular.forEach($scope.todos,function(todo) {
			count += todo.done ? 0 : 1;
		});
		return count;
	};
	
	$scope.archive = function() {
		var oldTodos = $scope.todos;
		$scope.todos = [{text: 'WILL be added on Archive', done:true}];
		angular.forEach(oldTodos,function(todo) {
			if (!todo.done) $scope.todo.push(todo);
		});
		$scope.message = "$scope.archive was called";
	};
	
	$scope.message="AngularJS controller is all set";
};