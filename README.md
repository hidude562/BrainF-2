# BrainF++
BrainF with some more functions.

## Docs:

All native brainF functions are still here and are the same (+-[].,><), so those characters won't be touched on in this.
Each place in memory is stored as an unsigned floating point number from 0-255 for legacy purposes, so you can have a value like 1.5 and values outside of the range would under/overflow
The memory is 2D so it would look like this

[[0, 0, 0],<br>
[0, 0, 0],<br>
[0, 0, 0]]

<br>

<table>
  <tr>
    <td><b>^</b></td>
    <td>Move pointer up</td>
  </tr>
  <tr>
    <td><b>Y</b></td>
    <td>Move pointer down</td>
  </tr>
  <tr>
    <td><b>*</b></td>
    <td>Multiply value at pointer by 2</td>
  </tr>
  <tr>
    <td><b>/</b></td>
    <td>Divide value at pointer by 2</td>
  </tr>
  <tr>
    <td><b>(</b></td>
    <td>Swap value of pointer - 1 and pointer</td>
  </tr>
  <tr>
    <td><b>)</b></td>
    <td>Swap value of pointer + 1 and pointer</td>
  </tr>
  <tr>
    <td><b>%</b></td>
    <td>Random number, either 0 or 1</td>
  </tr>
</table>
