import javax.swing.*;
import java.awt.*;

public class DealerMainFrame extends JFrame {

    private JButton addButton, goButton;

    private JTextArea searchTextArea;
    private JTextArea priceStart, priceEnd;
    private JTextArea yearStart, yearEnd;

    private JLabel searchLabel;
    private JLabel filterLabel;
    private JLabel priceLabel, yearLabel, colorLabel, categoryLabel, typeLabel, hyphenLabel;

    private JCheckBox colorBox, categoryBox, typeBox;

    public DealerMainFrame(){
        createComponents();
        setLayout();
        addComponents();
        //createListeners();
        //addListeners();
        makeItVisible();
    }

    private void makeItVisible() {
        setSize(1000,1000);
        setVisible(true);
        setResizable(true);
    }

    private void addComponents() {
        Container c = getContentPane();
        addLeftPanel(c);
        addRightPanel(c);
        addBottomPanel(c);
    }

    private void addBottomPanel(Container c) {
    }

    private void addRightPanel(Container c) {
        JPanel rightPanel = new JPanel();
        rightPanel.add(searchLabel);
        rightPanel.add(searchTextArea);
        
        
        c.add(rightPanel, "East");
    }

    private void addLeftPanel(Container c) {
        JPanel leftPanel = new JPanel();
        leftPanel.add(addButton);
        leftPanel.add(filterLabel);

        leftPanel.add(priceLabel);
        leftPanel.add(priceStart);
        leftPanel.add(hyphenLabel);
        leftPanel.add(priceEnd);

        leftPanel.add(yearLabel);
        leftPanel.add(yearStart);
        leftPanel.add(hyphenLabel);
        leftPanel.add(yearEnd);

        leftPanel.add(colorLabel);
        leftPanel.add(categoryLabel);
        leftPanel.add(typeLabel);

        leftPanel.add(goButton);

        c.add(leftPanel, "West");
    }

    private void createComponents() {
        addButton = new JButton("Add Car");
        goButton = new JButton("Go");
        searchTextArea = new JTextArea(1,6);
        searchLabel = new JLabel("Search: ");
        priceStart = new JTextArea(1,6);
        priceEnd = new JTextArea(1,6);
        yearStart = new JTextArea(1,6);
        yearEnd = new JTextArea(1,6);
        colorLabel = new JLabel("Colors");
        categoryLabel = new JLabel("Category");
        typeLabel = new JLabel("Type");
        filterLabel = new JLabel("Filer");
        priceLabel = new JLabel("Price");
        yearLabel = new JLabel("Year");
        hyphenLabel = new JLabel("-");
    }

    private void setLayout(){
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
    }


    public static void main(String[] args){
//        final JFrame mainFrame = new JFrame();
//        mainFrame.setTitle("Dealer Management");
//
//        mainFrame.setSize(400, 700);
//        mainFrame.setResizable(true);
//        mainFrame.setVisible(true);

        new DealerMainFrame();

    }
}
