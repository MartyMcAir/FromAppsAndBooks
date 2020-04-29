package b_BigTusks.ImageReader_1631;

import b_BigTusks.ImageReader_1631.common.ImageReader;
import b_BigTusks.ImageReader_1631.common.ImageTypes;

public class Solution {
    public static void main(String[] args) {
        ImageReader reader = ImageReaderFactory.getImageReader(ImageTypes.JPG);
//        ImageReader reader = ImageReaderFactory.getImageReader(ImageTypes.TIF); // IllegalArgumentException
//        ImageReader reader = ImageReaderFactory.getImageReader(null); // NullPointerException
    }
}
