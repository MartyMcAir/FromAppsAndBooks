package ImageReader_1631;

import ImageReader_1631.common.ImageReader;
import ImageReader_1631.common.ImageTypes;
import ImageReader_1631.common.ImageTypes;

public class Solution {
    public static void main(String[] args) {
        ImageReader reader = ImageReaderFactory.getImageReader(ImageTypes.JPG);
//        ImageReader reader = ImageReaderFactory.getImageReader(ImageTypes.TIF); // IllegalArgumentException
//        ImageReader reader = ImageReaderFactory.getImageReader(null); // NullPointerException
    }
}
