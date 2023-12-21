package com.example.imageclassification;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.Interpreter;
import org.tensorflow.lite.support.common.FileUtil;
import org.tensorflow.lite.support.common.TensorOperator;
import org.tensorflow.lite.support.common.TensorProcessor;
import org.tensorflow.lite.support.common.ops.NormalizeOp;
import org.tensorflow.lite.support.image.ImageProcessor;
import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.support.image.ops.ResizeOp;
import org.tensorflow.lite.support.image.ops.ResizeWithCropOrPadOp;
import org.tensorflow.lite.support.label.TensorLabel;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class TFLiteHelper {

    private int imageSizeX;
    private int imageSizeY;

    private List<String> labels;
    private Interpreter tflite;

    private MappedByteBuffer tfliteModel;
    private TensorImage inputImageBuffer;
    private TensorBuffer outputProbabilityBuffer;
    private TensorProcessor probabilityProcessor;

    private static final float IMAGE_MEAN = 0.0f;
    private static final float IMAGE_STD = 1.0f;

    private static final float PROBABILITY_MEAN = 0.0f;
    private static final float PROBABILITY_STD = 255.0f;

    private Activity context;

    TFLiteHelper(Activity context) {
        this.context = context;
    }

    // ---- Kolom inisiasi TensorFlow Lite Interpreter ----
    void init() {
        try{
            Interpreter.Options opt = new Interpreter.Options();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // ----------------------------------------------------


    // ---- Kolom preprocessing gambar ----
    private TensorImage loadImage(Final Bitmap bitmap){
        // loads bitmap into tensor image
        InputImageBuffer.load(bitmap);

        // creates processor for the tensor image
        int cropSize = Math.min(bitmap.getWidth(), bitmap.getHeight());
        // TODO: Fuse ops inside ImageProcessor
        ImageProcessor imageProcessor =
                new ImageProcessor.Builder()
                        .add(new ResizeWithCropOrPadOP(cropSize, cropSize))
                        .add(new ResizeOp(imageSizeX, imageSizeY, ResizeOP.ResizeMethod.NEAREST_NEIGHBOR))
                        .add(getPreprocessNormalizeOP())
                        .build();
        return imageProcessor.process(inputImageBuffer);
    }

    private TensorOperator getProcessNormalizeOp() {
        return new NormalizeOp(IMAGE_MEAN, IMAGE_STD);
    }
    // ----------------------------------------------------

    
    // ---- Kolom pemanggilan model tflite ----
    private MappedByteBuffer loadmodelfile(Activity activity) throws IOException {
        String MODEL_NAME = "vegs.tflite";
        AssetFileDescriptor fileDescriptor = activity.getAssets().openFd(MODEL_NAME);
        FileInputStream inputStream = new FileInputStream(fileDescriptor.getFileDescriptor());
        FileChannel fileChannel = inputStream.getChannel();
        long startoffset = fileDescriptor.getStartOffset();
        long declaredLength = fileDescriptor.getDeclaredLength();
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startoffset, declaredLength);
    }

    // ----------------------------------------------------
    
    
    // ---- Kolom klasifikasi ----


    // ----------------------------------------------------


    // ---- Kolom postprocessing ----


    // ----------------------------------------------------

}

