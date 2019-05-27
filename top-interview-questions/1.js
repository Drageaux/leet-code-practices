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
  var results = [];
  for (let i = 0; i < nums.length - 1; i++) {
    // dist wasn't hoisted on the same line
    for (let j = i + 1; j < nums.length; j++) {
      console.log(`i:${i} j:${j}`);
      if (nums[i] + nums[j] === target) {
        results.push(i, j);
        return results;
      }
    }
  }
  return results;
};

log = console.log;
// twoSum([2, 7, 11, 15], 9);

// best case O(1) cuz it gets only 2 els, worst cast
log(`brute force, slightly optimized`, twoSum([11, 15, 2, 7], 9));
