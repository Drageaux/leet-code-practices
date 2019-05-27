// https://leetcode.com/problemset/top-interview-questions/

/**
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

  Example:

Given nums = [2, 7, 11, 15], target = 9,

  Because nums[0] + nums[1] = 2 + 7 = 9,
  return [0, 1].
*/
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
  // brute
  for (let i = 0; i < nums.length - 1; i++) {
    // dist wasn't hoisted on the same line
    for (let j = i + 1; j < nums.length; j++) {
      // count++;
      // console.log(`${count}. i:${i}(${nums[i]}) j:${j}(${nums[j]})`);
      if (nums[i] + nums[j] === target) {
        return [nums[i], nums[j]];
      }
    }
  }
  return [];
};

var twoSumSubtract = function(nums, target, builtIn) {
  let arr = nums;

  while (arr.length) {
    let firstVal = arr[0];
    let firstIndex = nums.length - arr.length;
    let secondVal = target - firstVal;
    arr = arr.slice(1, arr.length);
    // use JS built-in
    if (true) {
      let goal = arr.findIndex(el => {
        return el === secondVal;
      });
      // don't forget to exclude self
      if (goal !== -1) {
        return [firstIndex, goal + (nums.length - arr.length)];
      }
    }
    // console.log(arr.length);
  }
  // for (let i = 0; i < arr.length; i++) {
  //   let firstVal = nums[i];
  //   let secondVal = target - firstVal;
  //   // use JS built-in
  //   if (true) {
  //     let j = nums.findIndex(el => {
  //       return el === secondVal;
  //     });
  //     // don't forget to exclude self
  //     if (i !== j && j !== -1) {
  //       return [i, j];
  //     }
  //   }
  //   // don't use JS built in
  //   else {
  //     // let second = nums.find(el => {
  //     //   return el === goal;
  //     // });
  //     // if (second !== null) {
  //     //   return [first, second];
  //     // }
  //   }
  // }
  return [];
};

log = console.log;
sT = console.time;
eT = console.timeEnd;
// twoSum([2, 7, 11, 15], 9);

let count = 0;
let ezInput = [2, 7, 11, 15];
let input = [];
let min = 0;
let max = 10000;
// has repeats
for (let i = 0; i < 10000; i++) {
  input.push(Math.floor(Math.random() * (+max - +min)) + +min);
}
// best case O(1) cuz it gets only 2 els, worst cast
sT('twoSum');
log(twoSum(input, 1235), `brute force, around 50th percentile performance\n`);
eT('twoSum');

sT('twoSumSubtract');
log(
  twoSumSubtract(input, 1235, true),
  `subtract and find, slow with big list\n`
);
eT('twoSumSubtract');
