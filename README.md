Bulgarian Tour
==============

ABDN project.
==============

About the project:

* BulgariaMainActivity use Tab Layout to render UI.
  The first tab populate data into grid view --> Cities Tab
  The second tab uses Recycle ListView to populate data --> History Tab

* PlacesListActivity extends BulgariaMainActivity and in this way, we get working ToolBar and Override method "onBackPressed". This method is used to handle onClick events on back_button from ToolBar menu.

* All data is accessible from class DataHolderModel. All images are stored in the drawable folder and strings in a string.xml file. The main purpose of a class is to act like data descriptor.

* Single Tone Model - to get access to data form DataHolderModel descriptor and shared and populate data in HistoryContent and PlacesContent classes. Here are created a data object and after that, we send objects is shared between last two classes and Recycle adapters. DataViewModel can safely handle screen configuration changes.

* When the user clicks on Grid Item inflate another Paces Fragment and display all places for the selected city. Data is populated with Recycle List View;

* PlacesListFragment uses card view to display data in a list. On item click intend new full-screen activity - DetailActivity where user get details about the chosen place;

![alt text](https://i.ibb.co/JzFygbw/bulgarian-tour.jpg)
