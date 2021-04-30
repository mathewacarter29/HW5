# Finger Painter
Finger Painter is an app that allows the user to take a picture on their android device, then draw on it and add icons to it.
---

## HW5

### User Stories
`TODO://` In the **User Stories section below**, add an `x` in the `-[ ]` like this `- [x]` for any user story you complete. (🚫 Remove this paragraph after after checking off completed user stories)

#### REQUIRED (100pts)
- [x] (20pts) App can take a picture and show it in the second activity
- [x] (20pts) App enables multi-touch drawing, with the selected color.
- [x] (15pt) App supports adding different icons by double-tapping and long-pressing gesture
- [x] (15pt) App supports the undoing the line-drawing and clearing the canvas
- [x] (10pts) After finishing one picture, the user can take another picture and edit it again 
- [x] (10pts) Bug free
- [x] (10pts) Submission follows the guidelines, and README file is complete

### App Walkthough GIF

<img src="YOUR_GIF_URL_HERE" width=250><br>

### Notes
One challenge I had was adding the icons to the canvas. I accomplished this by creating field varaibles that would hold the list of icons added and their respective positions on the
screen. I then drew these in the onDraw() method in myCanvas.

