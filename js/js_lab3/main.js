const number = Math.floor(7 * Math.random()) + 1;
console.log(number);
let count = 3;

document.getElementById('check').onclick = function () {
    if (--count > 0) {
        let userNum = document.getElementById('myNum').value;
        userNum = parseInt(userNum); // лише для чисел
        const out = document.getElementById('out');

        if (userNum === number) {
            out.innerHTML = 'Ура ви вгадали, ваш виграш становить 5$';
            alert ('Вітаємо вас, ви виграли! Ваш виграш - 5$. Сторінка буде перезапущена');
        location.reload();
        }
        else if (userNum > number) {
            out.innerHTML = 'Забагато';
        }
        else if (userNum < number) {
            out.innerHTML = 'Замало';
        }
        document.getElementById('count').innerHTML = 'Залишилось спроб: '+ count;

    }
    else {
        alert ('Спроби завершені, ви програли. Ваш виграш - 0$. Сторінка буде перезапущена');
        location.reload();
    }
}