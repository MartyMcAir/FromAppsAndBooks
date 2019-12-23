package ImageReader_1631;

import ImageReader_1631.common.*;

public class ImageReaderFactory {
    // Для каждого значения из ImageTypes возвращать соответствующий Reader,
    // например, для ImageTypes.JPG - JpgReader;
    // Если передан неправильный параметр, то выбрасывать исключение IllegalArgumentException("Неизвестный тип картинки").
    public static ImageReader getImageReader(ImageTypes image) {
        ImageReader result;
//        if (image instanceof JpgReader) {
//            result = new JpgReader();
//        }

//        switch (image) {
//            case JPG:
//                result = new JpgReader();
//                break;
//            case BMP:
//                result = new BmpReader();
//                break;
//            case PNG:
//                result = new PngReader();
//                break;
//            default:
//                throw new IllegalArgumentException("Неизвестный тип картинки");
//        }
//        if (result == null) {
//            throw new IllegalArgumentException("Неизвестный тип картинки");
//        }
        if (image == image.JPG) {
            result = new JpgReader();
        } else if (image == image.BMP) {
            result = new BmpReader();
        } else if (image == image.PNG) {
            result = new PngReader();
        } else {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
        return result;
    }

}
