let tasks = [
  { name: "Bài Tập ES6", complete: false },
  { name: "Bài Tập PHP", complete: false },
  { name: "Bài Tập Nodejs", complete: false },
  { name: "Bài Tập Java", complete: false },
];

document.addEventListener("DOMContentLoaded", () => {
  const renderProduct = (workList) => {
    let ul = document.getElementById("task-list");
    ul.innerHTML = "";
    workList.forEach((task, index) => {
      // Create tag `li`
      let li = document.createElement("li");

      // Create complete button
      let btnComplete = document.createElement("button");
      btnComplete.innerHTML = "Complete";
      btnComplete.classList.add("complete-btn");

      // create delete button
      let btnDelete = document.createElement("button");
      btnDelete.innerHTML = "Delete";
      btnDelete.classList.add("delete-btn");

      // Gan task vao li
      li.innerHTML = `<span class="task-name ${task.complete ? "strikethrough" : ""}">${task.name}</span>`;
      li.appendChild(btnComplete);
      li.appendChild(btnDelete);
      ul.appendChild(li);

      const taskName = li.querySelector(".task-name");

      // Sự kiện khi ấn nút Complete
      btnComplete.addEventListener("click", () => {
        task.complete = true; // Cập nhật trạng thái complete cho task
        taskName.classList.add("strikethrough");
        renderProduct(workList); // Render lại danh sách
      });

      // Sự kiện khi ấn nút Delete
      btnDelete.addEventListener("click", () => {
        workList.splice(index, 1); // Xóa task khỏi danh sách
        renderProduct(workList); // Render lại danh sách
      });
    });
  };

  renderProduct(tasks);
});
