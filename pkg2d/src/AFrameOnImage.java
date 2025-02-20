import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class AFrameOnImage {
    private boolean enablePaintRect = false; //biến này để bật tắt chế độ vẽ khung bao quanh hình ảnh
    private int []DimsBounds = new int[4]; //mảng này chứa thông tin về vị trí và kích thước của hình ảnh


    /*
    * Khi tạo đối tượng của lớp này, cần truyền vào 4 tham số là vị trí
    * x trên ảnh, vị trí y trên ảnh, chiều rộng và chiều cao của hình ảnh
    * */
    public AFrameOnImage(int xOnImage, int yOnImage, int w, int h){
        DimsBounds[0] = xOnImage;
        DimsBounds[1] = yOnImage;
        DimsBounds[2] = w;
        DimsBounds[3] = h;
    }
    public void VisibleRectDebug(boolean enable){ //hàm này để bật tắt chế độ vẽ khung bao quanh hình ảnh
        enablePaintRect = enable;
    }
    public int[] GetBounds(){ // hàm này trả về mảng chứa thông tin về vị trí và kích thước của hình ảnh
        return DimsBounds;
    }
    public void Paint(int x, int y, BufferedImage image, Graphics2D g2, int anchor, float rotation) {
        /*
         * Hàm này dùng để vẽ hình ảnh
         * các tham số có nghĩa là:
         * x, y: vị trí cần vẽ hình ảnh
         * image: ảnh nguồn
         * g2: đối tượng Graphics2D để vẽ
         * anchor: điểm neo, nếu anchor = 0 thì hình ảnh sẽ được vẽ từ góc trên bên trái
         * rotation: góc quay của hình ảnh
         * */
        BufferedImage imageDraw = image.getSubimage(DimsBounds[0], DimsBounds[1], DimsBounds[2], DimsBounds[3]); //lấy hình ảnh cần vẽ từ ảnh nguồn
        AffineTransform tx = new AffineTransform(); //tạo một đối tượng AffineTransform để thực hiện việc quay hình ảnh
        tx.rotate(rotation, imageDraw.getWidth() / 2, imageDraw.getHeight() / 2); //quay hình ảnh
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR); //tạo một đối tượng AffineTransformOp để thực hiện việc quay hình ảnh

        g2.drawImage(imageDraw, x, y, null); //vẽ hình ảnh
        if (enablePaintRect) PaintBound(g2); //nếu enablePaintRect = true thì vẽ khung bao quanh hình ảnh
    }

    private void PaintBound(Graphics2D g2) {
    }
}
