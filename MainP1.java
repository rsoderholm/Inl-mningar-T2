package p1;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class MainP1 {
	public static void main(String[] args) {
		Buffer<Icon> iconBuffer = new Buffer<Icon>();
		Buffer<IconProducer> producerBuffer	= new Buffer<IconProducer>();
		
		IconManager iconManager = new IconManager(iconBuffer);
		new ViewerWindow( new Viewer(iconManager,640,480) ,100,100 );
		new ViewerWindow( new Viewer(iconManager,320,320) ,400,100 );
		iconManager.start();
		
		Producer producer = new Producer(producerBuffer,iconBuffer);
		producer.start();
		
		IconProducerManager ipManager = new IconProducerManager(producerBuffer);		
		ipManager.addIconProducer(new ArrayProducer(getIconArray(),50,10));
	}
	
	private static Icon[] getIconArray() {
		Icon[] res = {new ImageIcon("files/new1.jpg"),
				new ImageIcon("files/new2.jpg"),
				new ImageIcon("files/new3.jpg"),
				new ImageIcon("files/new4.jpg"),
				new ImageIcon("files/new5.jpg"),
				new ImageIcon("files/new6.jpg"),
				new ImageIcon("files/new7.jpg"),
				new ImageIcon("files/new8.jpg"),
				new ImageIcon("files/new9.jpg"),
				new ImageIcon("files/new10.jpg")};
		return res;
	}
}


public class FileProducer implements IconProducer {
    private ArrayList<Icon> list = new ArrayList<Icon>();
    private int delay=0;
    private int times=0;
    private int currentIcon = -1;
    
    public FileProducer(String filename) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename),"UTF-8"))) {
            times = Integer.parseInt(br.readLine());
            delay = Integer.parseInt(br.readLine());
            String str = br.readLine();
            while(str!=null) {
                addIcon(str);
                str = br.readLine();
            }
        } catch(IOException e) {}
    }
    
    private void addIcon(String filename) {
        Icon icon = new ImageIcon(filename);
        if(icon!=null) {
            list.add(icon);
        }
    }
    
    public int delay() {
        return delay;
    }
    
    @Override
    public int times() {
        return times;
    }
    
    @Override
    public int size() {
        return list.size();
    }
    
    @Override
    public Icon nextIcon() {
        if(list.size()==0)
            return null;
        currentIcon = (currentIcon+1) % list.size();
        return list.get(currentIcon);
    }
    
}
