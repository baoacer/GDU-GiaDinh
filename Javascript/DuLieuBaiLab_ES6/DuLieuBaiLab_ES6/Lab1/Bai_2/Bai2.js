document.addEventListener('DOMContentLoaded', () => {
    const user = {
        name: 'Cho Hoang',
        age: 20,
        email: 'hoangthieuem@gmail.com',
    }

    const {name, age, email} = user;
    document.querySelector('.name').innerHTML = name;
    document.querySelector('.age').innerHTML = age;
    document.querySelector('.email').innerHTML = email;
})