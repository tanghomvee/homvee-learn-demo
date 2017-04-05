package demo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.DefaultTreeModel;

import root.FileUtil;

public class DemoMain {
    public static void main(String[] args) throws Exception {
        JFrame.setDefaultLookAndFeelDecorated(true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        JFrame frame = new JFrame("Case Tools");
        frame.setPreferredSize(new Dimension(800, 800));
        JTree tree = new JTree();
        //构造树状目录
        File file = new File(DemoMain.class.getClass().getResource("/").getPath() + File.separator + "root");
        CheckBoxTreeNode rootNode = FileUtil.makeTree(file);

        DefaultTreeModel model = new DefaultTreeModel(rootNode);

        tree.setModel(model);
        tree.setCellRenderer(new CheckBoxTreeCellRenderer());
        JScrollPane scroll = new JScrollPane(tree);
        scroll.setPreferredSize(new Dimension(300, 700));

        //操作区
        JPanel operations = new JPanel();
        operations.setPreferredSize(new Dimension(800, 30));
        JButton refresh = new JButton("刷新");
        JButton exec = new JButton("执行");
        operations.add(refresh);
        operations.add(exec);
        operations.setLayout(new BoxLayout(operations, BoxLayout.X_AXIS));

        //显示区
        JPanel show = new JPanel();
        show.setPreferredSize(new Dimension(480, 660));
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        JTextArea info = new JTextArea();
        info.setEditable(false);
        tabbedPane.add(info, "信息");
        JTextArea result = new JTextArea();
        result.setEditable(false);
        tabbedPane.add(result, "执行结果");
        tabbedPane.setPreferredSize(show.getPreferredSize());
        tabbedPane.setAutoscrolls(true);
        show.add(tabbedPane);
        JScrollPane jshow = new JScrollPane(show);
        jshow.setPreferredSize(new Dimension(490, 700));


        //状态区
        JScrollPane footer = new JScrollPane();
        JTextArea footerInfo = new JTextArea();
        footerInfo.setEditable(false);
        footer.add(footerInfo);

        footer.setPreferredSize(new Dimension(800, 70));


        //绑定事件
        ButtonAction buttonAction = new ButtonAction(rootNode, tabbedPane, tree);
        refresh.addActionListener(buttonAction);
        exec.addActionListener(buttonAction);
        tree.addMouseListener(new CheckBoxTreeNodeSelectionListener(buttonAction));


        frame.getContentPane().add(operations, BorderLayout.NORTH);
        frame.getContentPane().add(footer, BorderLayout.SOUTH);


        frame.getContentPane().add(scroll);
        frame.getContentPane().add(scroll, BorderLayout.WEST);
        frame.getContentPane().add(jshow, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.pack();
    }
}
