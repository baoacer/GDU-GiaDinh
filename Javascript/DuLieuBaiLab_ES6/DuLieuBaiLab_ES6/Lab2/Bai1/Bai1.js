document.getElementById("calculate-btn").addEventListener("click", (event) => {
    event.preventDefault();

    const num1 = document.getElementById("num1").value;
    const num2 = document.getElementById("num2").value;

    const sum = (num1, num2) => {
        return parseFloat(num1) + parseFloat(num2);
    }

    const result = document.getElementById("result");
    result.innerHTML = sum(num1, num2);

})