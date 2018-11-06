//打印乘法表
function showMultiplicationTables(x) {
    for (i = 1; i <= x; i++) {
        let sum = 0;
        console.log("\n")
        for (j = i; j <= 9; j++) {
            sum = i * j;
            console.log(i + "*" + j + "=" + sum);
        }
    }
}

// showMultiplicationTables(6);
//打印矩阵
function showMatrix(row) {
    let star = "";
    for (let i = 0; i < row / 2; i++) {
        star += "*";
        console.log(star);
    }
    for (let i = 0; i < parseInt(row / 2); i++) {
        let star = "";
        for (let j = 0; j < parseInt(row / 2) - i; j++) {
            star += "*";
        }
        console.log(star);
    }
}

showMatrix(7)


//斐波那契数列
function fibonacci(n) {
    if (n == 1 || n == 2) {
        return 1;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
}

// for (let i = 1; i < 7; i++) {
//     console.log(fibonacci(i))
// }


//冒泡排序
function bubberSort(arr) {
    let temp = 0;
    for (let i = 0; i < arr.length - 1; i++) {
        for (let j = 0; j < arr.length - 1 - i; j++) {
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
    return arr;
}


//选择排序
function selectSort(arr) {
    let index;
    let temp;
    for (let i = 0; i < arr.length - 1; i++) {
        index = i;
        for (let j = i + 1; j < arr.length; j++) {
            if (arr[index] > arr[j]) {
                index = j;
            }
        }
        if (index != i) {
            temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }
    return arr;
}


//二分查找
function binarySearch(arr, temp) {
    let arrSort = selectSort(arr);
    console.log(arrSort);
    let pos = -1;
    let start = 0;
    let end = arrSort.length - 1;
    while (start <= end) {
        let mem = parseInt((start + end) / 2);
        if (temp > arrSort[mem]) {
            start = mem + 1;
        } else if (temp < arrSort[mem]) {
            end = mem - 1;
        } else {
            pos = mem;
            break;
        }
    }
    return pos;
}


//求多层数组的总和
function getSum(arr) {
    // return arr.reduce((prev, cur) => prev.concat(cur)).reduce((p, c) => p + c);
    return arr.reduce((p,c)=>[...p,...c]).reduce((p,c)=>p+c)
}

let sum = getSum([[1, 2], [1, 2], [1, 2]]);
console.log(sum);