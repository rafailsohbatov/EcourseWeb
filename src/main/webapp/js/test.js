function testFunction(a, b) {
    if (a > b) {
        console.log("a b den boyukdur")
    } else if (a < b) {
        console.log("a b den kicikdir")
    } else {
        console.log("a b ye beraberdir")
    }
}

function printingNumbers(a, b) {
    if (a > b) {
        a = a + b;
        b = a - b;
        a = a - b;
    }
    console.log(a);
    if (a != b) {
        printingNumbers(++a, b);
    }
}