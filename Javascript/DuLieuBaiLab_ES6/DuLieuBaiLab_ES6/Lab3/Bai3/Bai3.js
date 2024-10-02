const form = document.getElementById('todoForm');
const task = document.getElementById('task');
const message = document.getElementById('message');
const todoList = document.getElementById('todoList');

let todos = []

form.addEventListener('submit', (event) => {
    event.preventDefault();
    const taskName = task.value.trim()  
    themTask(taskName);
    task.value = '';
})

// bat dong bo
const addTask = (taskName) => {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            if(taskName){
                const newTask = { name: taskName, complete: false };
                todos = [...todos, newTask];
                resolve()
            }else{
                reject('Them khong thanh cong')
            }
        }, 1000);
    })
}// end

const themTask = async (taskName) => {
    try {
        const newTask = await addTask(taskName);
        renderTask();
    } catch (err) {
        message.textContent = err;
        message.style.color = 'red';
    }
}


const renderTask = () => {
    todoList.innerHTML = '';
    todos.forEach(( task, index ) => {
        const { name, complete } = task;
        const li = document.createElement('li');
        const span = document.createElement('span');
        span.classList.add('todo-item')
        if(complete){
            span.classList.add('completed')
        }
        span.textContent = name;
        li.appendChild(span);

        const completeBtn = document.createElement('button');
        completeBtn.textContent = 'Complete';
        completeBtn.classList.add('complete-btn');
        completeBtn.onclick = () => {
            htCongViec(index)
        }
        li.appendChild(completeBtn);

        const deleteBtn = document.createElement('button');
        deleteBtn.textContent = 'Delete';
        deleteBtn.classList.add('delete-btn');
        deleteBtn.onclick = () => {
            xoaCV(index)
        }
        li.appendChild(deleteBtn);

        todoList.appendChild(li);
    })
}

const completeCV = (index) => {
    return new Promise((resolve) => {
        const newTask = todos.map((p, i) => i===index ? {...p, complete: !p.complete} : p);
        resolve(newTask);
    })
}

const htCongViec = async (index) => {
    try {
        const newTask = await completeCV(index);
        todos = newTask;
        renderTask();
    } catch (err) {
        message.textContent = err;
        message.style.color = 'red';
    }
}

const deleteCV = (index) => {
    return new Promise((resolve) => {
        const newTask = todos.filter((p, i) => i !== index);
        resolve(newTask);
    })
}

const xoaCV = async (index) => {
    try {
        const newTask = await deleteCV(index);
        todos = newTask;
        renderTask();
    } catch (err) {
        message.textContent = err;
        message.style.color = 'red';
    }
}
    








