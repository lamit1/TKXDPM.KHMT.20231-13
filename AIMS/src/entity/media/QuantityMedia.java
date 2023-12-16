package entity.media;


/**
 * Thực hiện đúng Single Responsibility:
 * Thực hiện các lưu trữ dữ liệu của Media và các lớp khác như Cart và Order
 */
public class QuantityMedia {
    
    private Media media;
    private int quantity;
    private int price;


    public QuantityMedia(Media media, int quantity, int price) {
        this.media = media;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * All function here are all communicational cohesion
     * because all are used for purpose get cart media information
     */
    public Media getMedia() {
        return this.media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}

    
