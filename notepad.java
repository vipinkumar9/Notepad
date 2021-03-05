import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Flow;
import javax.swing.*;
public class notepad {

    private static JMenuBar mb;
    private static JMenu m1,m2,m3,m4;
    private static JMenuItem m11,m12,m13,m14;
    private static JFrame frame;
    private static FileReader rf;
    private static FileWriter wf;
    private static File file;
    private static JTextArea textArea;
    private static JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10;
    private static JTabbedPane tabbedPane;

    public static void addMenu(int tab_count){

        mb = new JMenuBar();
        m1 = new JMenu("File");
        m2 = new JMenu("Tools");
        m3 = new JMenu("Preferences");
        m4 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        mb.add(m4);
        m11 = new JMenuItem("New File");
        m12 = new JMenuItem("Open");
        m13 = new JMenuItem("Save");
        m14 = new JMenuItem("Save as");
        m1.add(m11);
        m1.add(m12);
        m1.add(m13);
        m1.add(m14);
        m11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                tabCreator(tab_count);
            }
        });

        m12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    openFile(tab_count);
                } catch (IOException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Something went Wrong\nPlease try again");
                }
            }
        });

        m13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    save();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        m14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    saveAs();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void openFile(int tab_count) throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int res = fileChooser.showOpenDialog(fileChooser.getParent());
        if(res == JFileChooser.APPROVE_OPTION){
            file = fileChooser.getSelectedFile();
            FileReader fr = new FileReader(file);
            int i;
            String data = "";
            while ((i = fr.read()) != -1){
                data = data + (char)i;
            }
            textArea.setText(data);
            //Desktop.getDesktop().open(file);
            set_filename(tab_count);
            fr.close();
        }

    }

    public static boolean save() throws IOException {
        String data = textArea.getText();
        String path = null;
        try{
            path = file.getPath();
            wf = new FileWriter(path);
            wf.write(data);
            wf.close();
        }
        catch (Exception e){
            saveAs();
        }

        return true;
    }

    public static void saveAs() throws IOException {
        JFileChooser j = new JFileChooser();
        j.setCurrentDirectory(new File(System.getProperty("user.home")));
        int res = j.showSaveDialog(j.getParent());
        if (res == JFileChooser.APPROVE_OPTION){
            file = j.getSelectedFile();
            wf = new FileWriter(file);
            wf.write(textArea.getText());
            wf.close();
        }
    }

    public static void tabCreator(int tab_count){
        switch (tab_count){
            case 0:
                tabbedPane.addTab("New File",p1);
                tabbedPane.setSelectedIndex(0);
                textArea.setText("");
                tab_count += tab_count;
                break;
            case 1:
                tabbedPane.addTab("New File",p2);
                tabbedPane.setSelectedIndex(1);
                textArea.setText("");
                tab_count += tab_count;
                break;
            case 2:
                tabbedPane.addTab("New File",p3);
                tabbedPane.setSelectedIndex(2);
                textArea.setText("");
                tab_count += tab_count;
                break;
            case 3:
                tabbedPane.addTab("New File",p4);
                tabbedPane.setSelectedIndex(3);
                textArea.setText("");
                tab_count += tab_count;
                break;
            case 4:
                tabbedPane.addTab("New File",p5);
                tabbedPane.setSelectedIndex(4);
                textArea.setText("");
                tab_count += tab_count;
                break;
            case 5:
                tabbedPane.addTab("New File",p6);
                tabbedPane.setSelectedIndex(5);
                textArea.setText("");
                tab_count += tab_count;
                break;
            case 6:
                tabbedPane.addTab("New File",p7);
                tabbedPane.setSelectedIndex(6);
                textArea.setText("");
                tab_count += tab_count;
                break;
            case 7:
                tabbedPane.addTab("New File",p8);
                tabbedPane.setSelectedIndex(7);
                textArea.setText("");
                tab_count += tab_count;
                break;
            case 8:
                tabbedPane.addTab("New File",p9);
                tabbedPane.setSelectedIndex(8);
                textArea.setText("");
                tab_count += tab_count;
                break;
            case 9:
                tabbedPane.addTab("New File",p10);
                tabbedPane.setSelectedIndex(9);
                textArea.setText("");
                tab_count += tab_count;
                break;
            default:
                JOptionPane.showInputDialog("You Exceed Maximum Tab limit");
        }

    }

    public static void set_filename(int Tab_count){
        String name = file.getName();
        switch (Tab_count){
            case 0:
                tabbedPane.addTab(name,p1);
                tabbedPane.setSelectedIndex(0);
                Tab_count += Tab_count;
                break;
            case 1:
                tabbedPane.addTab(name,p2);
                tabbedPane.setSelectedIndex(1);
                Tab_count += Tab_count;
                break;
            case 2:
                tabbedPane.addTab(name,p3);
                tabbedPane.setSelectedIndex(2);
                Tab_count += Tab_count;
                break;
            case 3:
                tabbedPane.addTab(name,p4);
                tabbedPane.setSelectedIndex(3);
                Tab_count += Tab_count;
                break;
            case 4:
                tabbedPane.addTab(name,p5);
                tabbedPane.setSelectedIndex(4);
                Tab_count += Tab_count;
                break;
            case 5:
                tabbedPane.addTab(name,p6);
                tabbedPane.setSelectedIndex(5);
                Tab_count += Tab_count;
                break;
            case 6:
                tabbedPane.addTab(name,p7);
                tabbedPane.setSelectedIndex(6);
                Tab_count += Tab_count;
                break;
            case 7:
                tabbedPane.addTab(name,p8);
                tabbedPane.setSelectedIndex(7);
                Tab_count += Tab_count;
                break;
            case 8:
                tabbedPane.addTab(name,p9);
                tabbedPane.setSelectedIndex(8);
                Tab_count += Tab_count;
                break;
            case 9:
                tabbedPane.addTab(name,p10);
                tabbedPane.setSelectedIndex(9);
                Tab_count += Tab_count;
                break;
            default:
                JOptionPane.showInputDialog("You Exceed Maximum Tab limit");
                break;
        }

    }

    public static void main(String[] arg){
        int Tab_count = 0;
        addMenu(Tab_count);

        frame = new JFrame();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        tabbedPane = new JTabbedPane();
        textArea = new JTextArea();
        JInternalFrame internalFrame = new JInternalFrame("tab",false,false,false,false);
        JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        JPanel panel = new JPanel();
        int sheight = (int) dimension.getHeight();
        int swidth = (int) dimension.getWidth();

        //adding menuBar,tabs,scrollbar on frame and internal frame
        tabbedPane.addTab("New File",panel);
        internalFrame.setBounds(0,0,swidth - 15, 50);
        internalFrame.getContentPane().add(BorderLayout.NORTH, mb);
        internalFrame.setVisible(true);

       // frame.add(internalFrame);
        frame.getContentPane().add(BorderLayout.NORTH, internalFrame);
        frame.getContentPane().add(BorderLayout.EAST, scrollPane);
        frame.getContentPane().add(BorderLayout.SOUTH, tabbedPane);

        //frame.add(textArea);
        frame.getContentPane().add(BorderLayout.CENTER, textArea);
        frame.setSize(swidth, sheight);
        frame.setVisible(true);
    }
}
