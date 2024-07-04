# Deploy With TensorFlow Lite
## About
this is an Image Classification model to detect what type of food based on the image

## Getting Started
- install android studio
### Create android virtual device
- at the start window click on the more options and then choose virtual device manager
- create a new virtual device and select hardware, i choose Pixel 5 and then click next
- choose a system image, i choose R and then click next
- your android virtual device is ready
### Run project
- open the folder of this project with android studio
- wait for android studio to sync and then click run app
- your android virtual device will show up
- inside the android virtual device click on the green box
- drag and drop your own images or use the images in images_predict
- navigate to the download tab inside the android device
- after the image is shown, click the classify button
- the prediction will popup above the image

## Files
- dataset_1 folder &rarr; folder dataset for model training
- images_predict folder &rarr; folder images to use for predicting images in android emulator
- SimpleImageClassification folder &rarr; android studio project folder
- deploy_model_with_tensorflow_lite.ipynb &rarr; the notebook file containing the trained model
- vegs.txt &rarr; label for image classification
- vegs.tflite &rarr; the model that has been converted

# Note
at this point in time 23/12/2023 i have not mastered android development, the code that i use is managed by dicoding
