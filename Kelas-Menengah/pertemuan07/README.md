# Deploy With Tensorflow.js
## About
this is an NLP model to detect whether a review is a positive review or a negative review

## Getting Started
- install live server extension on vscode (or use any other web server)
- open the index.html
- right click on the index.html and select "open with live server"
- wait for the model to load
- write your review in the input text and click the "post review" button
- result will popup in the alert box

## Files
- index.html &rarr; the file to use the model
- deploy_model_with_tensorflowjs.ipynb &rarr; the notebook file containing the trained model
- script.js &rarr; file to load the model into index.html
- yelp_labelled.txt &rarr; the dataset used to train model
- word_index.json &rarr; list of word that was saved into the model using tokenizer
- model.h5 &rarr; the model that has been saved as h5 file
- tfjs_model folder &rarr; folder with the model that has been converted into json and the weight of the model
- styles folder &rarr; folder with the css file and images that is used in html file
- images folder &rarr; folder with the model accuracy and loss plot saved as an image