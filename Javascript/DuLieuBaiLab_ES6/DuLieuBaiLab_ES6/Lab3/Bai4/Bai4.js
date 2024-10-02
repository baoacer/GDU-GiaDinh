document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('userForm');
    const message = document.getElementById('message');
    const userList = document.getElementById('userList');

    let users = []

    form.addEventListener('submit', (event) => {
        event.preventDefault();
        const name = document.getElementById('username').value;
        themUser(name);
        renderUser();
    })

    const addUser = (name) => {
        return new Promise((resolve) => {
            setTimeout(() => {
                const newUser = { name: name};
                users = [...users, newUser];
                resolve();
            }, 200);
        })
    }

    const themUser = async (name) => {
        try {
            const newUser = await addUser(name);
            renderUser();
        } catch (error) {
            message.textContent = error;
            message.style.color = 'red';
        }
    }

    const removeUser = (index) => {
        return new Promise((resolve) => {
            setTimeout(() => {
                const newUsers = users.filter((p, i) => i !== index);
                users = newUsers;
                resolve();
            }, 200);
        })
    }

    const xoaUser = async (index) => {
        try {
            const newUser = await removeUser(index);
            renderUser();
        } catch (error) {
            message.textContent = error;
            message.style.color = 'red';
        }
    }

    const renderUser = () => {
        userList.innerHTML = '';
        users.forEach((user, index) => {
            const li = document.createElement('li');
            li.textContent = `${user.name}`;
            const deleteBtn = document.createElement('button');
            deleteBtn.textContent = 'Xoa';
            deleteBtn.onclick = () => {
                xoaUser(index);
            }
            li.appendChild(deleteBtn);
            userList.appendChild(li);
        });
    }   
})