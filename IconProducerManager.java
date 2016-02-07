package p1;

/**
 * Adds an iconproducer object to the object inside IconProducerManager
 * 
 * @author robinsoderholm
 *
 */

public class IconProducerManager {
	private Buffer<IconProducer> buffer;

	public IconProducerManager(Buffer<IconProducer> producerBuffer) {
		this.buffer = producerBuffer;
	}

	public void addIconProducer(IconProducer producer) {
		buffer.put(producer);
	}

}
