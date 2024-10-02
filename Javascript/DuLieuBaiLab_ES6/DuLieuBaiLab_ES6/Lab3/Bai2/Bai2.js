const message = document.getElementById("message");
const userList = document.getElementById("userList");
const userForm = document.getElementById('userForm');

document.addEventListener("DOMContentLoaded", () => {

    let users = [];

    const addUser = (name, email) => {
        return new Promise((resolve) => {
            setTimeout(() => {
                users.push({ name, email });
                resolve(); // Giải quyết Promise sau khi thêm người dùng
            }, 200);
        });
    }

    const deleteUser = (index) => {
        return new Promise((resolve) => {
            setTimeout(() => {
                users.splice(index, 1);
                resolve(); // Giải quyết Promise sau khi xóa người dùng
            }, 200);
        });
    }

    const updateMessage = (msg) => {
        message.innerHTML = msg;
        setTimeout(() => {
            message.innerHTML = '';
        }, 1000); // Thông báo sẽ biến mất sau 1 giây
    }

    const renderUser = () => {
        userList.innerHTML = '';
        users.forEach((user, index) => {
            const li = document.createElement('li');
            li.textContent = `${user.name} - ${user.email}`;
            const deleteBtn = document.createElement('button');
            deleteBtn.textContent = 'Xóa';
            deleteBtn.addEventListener('click', () => {
                deleteUser(index).then(() => {
                    updateMessage('Người dùng đã được xóa.');
                    renderUser();
                });
            });
            li.appendChild(deleteBtn);
            userList.appendChild(li);
        });
    }

    userForm.addEventListener('submit', (event) => {
        event.preventDefault();
        const name = document.getElementById('name').value;
        const email = document.getElementById('email').value;

        addUser(name, email).then(() => {
            updateMessage('Người dùng được thêm.');
            renderUser();
            userForm.reset(); // Reset form sau khi thêm người dùng
        });
    });

    renderUser();
});
