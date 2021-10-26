let array = [1, 2, 3];
forEach(array, print);
console.log();
//---------------------------------------------------
let newArray = getTransformedArray(array, increment);
console.log(newArray);
console.log();
//---------------------------------------------------
let presidents = [{
    name: "Petro",
    surname: "Poroshenko"
    }, {
    name: "Barak",
    surname: "Obeme"
    }
]
pluckByAttribute(presidents, "surname");
console.log();
//---------------------------------------------------
let obj = {
    a: "o",
    c: "d",
    t: "g"
}
console.log(cypherPhrase(obj, "kitty cat"));
console.log();
//---------------------------------------------------
console.log(decypherPhrase(obj, "kiggy dog"));

//---------------------------------------------------

function forEach(array, func) {

    for (let i = 0; i < array.length; i++) {
        func(array[i]);
    }
}

function print(elem) {
    console.log(elem);
}


function getTransformedArray(array, func) {

    for (let i = 0; i < array.length; i++) {
        array[i] = func(array[i]);
    }
    return array;
}
function increment(elem) {
    return ++elem;
}

function pluckByAttribute(objects, str) {

    for (let i = 0; i < objects.length; i++) {
        console.log(objects[i][str]);
    }
}

function cypherPhrase(object, str) {

    for (let i = 0; i < str.length; i++) {
        if (object[str[i]] !== undefined) {
            str = str.substr(0, i) + object[str[i]] + str.substr(i + 1, str.length);
        }
    }
    return str;
}

function decypherPhrase(object, str) {

    for (let i = 0; i < str.length; i++) {
        if (Object.keys(object).find(key => object[key] === str[i])) {
            str = str.substr(0, i) + Object.keys(object).find(key => object[key] === str[i]) + str.substr(i + 1, str.length);
        }
    }
    return str;
}
