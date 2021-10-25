window.addEventListener('load', function(e) {
	console.log('script.js loaded')
	init();
	

});

function init() {
	document.taskForm.lookup.addEventListener('click', function(event) {
		event.preventDefault();
		var taskId = document.taskForm.taskId.value;
		if (!isNaN(taskId) && taskId > 0) {
			getTask(taskId);
		};
		
	});
	document.addTaskForm.addTask.addEventListener('click', function(event) {
		event.preventDefault();
		let fm = document.addTaskForm;
		let newTask = {
			name: fm.name.value,
			details: fm.details.value,
			location: fm.location.value,
			taskDate: fm.taskDate.value,
			taskTime: fm.taskTime.value,
			category: fm.category.value,
			priorityLevel: fm.priorityLevel.value,
			notes: fm.notes.value,
			status: fm.status.value,


		};
		console.log(newTask);
		postNewTask(newTask);
	});
}



	function getTask(taskId) {
		console.log('getTask(): taskId is ' + taskId);

		let xhr = new XMLHttpRequest();
		xhr.open('GET', 'api/task/' + taskId);
		xhr.onreadystatechange = function() {
			if (xhr.readyState === 4) {
				if (xhr.status === 200) {


					let taskJson = xhr.responseText;
					let task = JSON.parse(taskJson);
					displayTask(task);

				} else {



				}

			}

		}
		xhr.send();
	}




	function displayTask(task) {
		var dataDiv = document.getElementById('taskData');
		dataDiv.textContent = '';
		let h1 = document.createElement('h1');
		h1.textContent = task.name;
		dataDiv.appendChild(h1);
		let bq = document.createElement('blockquote');
		bq.textContent = task.details;
		dataDiv.appendChild(bq);

		let ul = document.createElement('ul');
		dataDiv.appendChild(ul);
		let li = document.createElement('li');
		li.textContent = task.location;
		ul.appendChild(li);
		li = document.createElement('li');
		li.textContent = task.taskDate;
		ul.appendChild(li);
		li = document.createElement('li');
		li.textContent = task.taskTime;
		ul.appendChild(li);
		li = document.createElement('li');
		li.textContent = task.category;
		ul.appendChild(li);
		li = document.createElement('li');
		li.textContent = task.priorityLevel;
		ul.appendChild(li);
		li = document.createElement('li');
		li.textContent = task.notes;
		ul.appendChild(li);
		li = document.createElement('li');
		li.textContent = task.status;
		ul.appendChild(li);


	}


function postNewTask(newTask) {
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'api/task');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200 || xhr.status === 201) {
				let task = JSON.parse(xhr.responseText);
				displayTask(task);
			}
		}
		else {
			console.log('err')
		}
	};

	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(JSON.stringify(newTask));

	//todo 
	//retireve all tasks and display in table
	//click on a task to display details
	//button to delete tracker
	//button to update, load tasks into form
}


