type MultiDimensionalArray = (number | MultiDimensionalArray)[];

var flat = function (arr:  MultiDimensionalArray, n: number):  MultiDimensionalArray {
    const arr2: MultiDimensionalArray = [];
    flatArray(arr, n, arr2);
    return arr2;
};

const flatArray = (arr: MultiDimensionalArray, n: number, arr2: MultiDimensionalArray) => {
    
        for (let i = 0; i < arr.length; i++) {
            if (typeof arr[i] === 'number') {
                arr2.push(arr[i]);
                continue;
            }
            if (n === 0) {
                arr2.push(arr[i]);
                continue;
            }
            flatArray(arr[i] as MultiDimensionalArray, n-1, arr2);
        }
}