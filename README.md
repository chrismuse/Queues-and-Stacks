# Queues-and-Stacks
Queues and Stacks backed by LinkedLists and Arrays

Assignment:

Stacks and Queues
You are to code the following:
1. A stack backed by a linked list
2. A stack backed by an array
3. A queue backed by a linked list
4. A queue backed by an array
A queue is a first-in, first-out (FIFO) data structure. A stack is a last-in, first-out (LIFO) data
structure.
All of your data structures should implement the appropriate interface, either QueueInterface or
StackInterface. Both interfaces define an initial capacity that you must use in your array implementations;
make sure to use the provided variable, not a magic number. Your linked list implementations
should use the given head (and tail) pointer(s) to build the backing structure. Do NOT use Java’s linked
list classes.
As always, these implementations must be as efficient as possible. Failure to do so will result in
large point deductions.
Circular Arrays
The backing array in your ArrayQueue implementation must behave circularly. This means that when
the user dequeues an element, you should simply treat the next index in the array as the new front.
DO NOT SHIFT ANY ELEMENTS IN THE ARRAY. This also means that if there are empty
spaces at the front of the array, the back of the queue should wrap around to the front of the array and
make use of those spaces.
When regrowing the backing array, realign the queue with the front of the new array during transfer,
so that the front of the queue is once again at index 0. This is the ONLY time that the front of the
queue should be reset. When dequeueing the last element in the queue, simply increment front as you
normally would and leave it there.
