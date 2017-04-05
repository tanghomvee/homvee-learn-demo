package demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import root.FileUtil;

public class ButtonAction implements ActionListener {

    private CheckBoxTreeNode rootNode;
    private JTree tree;
    private JTabbedPane tabbedPane;

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String type = button.getText();
        if ("刷新".equals(type)) {//根据不通Type设置当前激活的面板
            tabbedPane.setSelectedIndex(0);
            File file = new File(this.getClass().getResource("/").getPath() + File.separator + "root");
            try {
                CheckBoxTreeNode rootNode = FileUtil.makeTree(file);
                DefaultTreeModel model = new DefaultTreeModel(rootNode);
                tree.setModel(model);
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        } else {
            String path = new String();
            tabbedPane.setSelectedIndex(1);
            try {
                getNodePath(rootNode, path);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public ButtonAction(CheckBoxTreeNode rootNode, JTabbedPane tabbedPane, JTree tree) {
        super();
        this.rootNode = rootNode;
        this.tabbedPane = tabbedPane;
        this.tree = tree;
    }

    public void getNodePath(CheckBoxTreeNode nodeParent, String path) throws IOException {
        //获取被选中的节点
        path += (File.separator + nodeParent);
        if (nodeParent.isLeaf() && nodeParent.isSelected()) {
            //读取XML文件
            path = DemoMain.class.getClass().getResource("/").getPath() + path + File.separator + nodeParent + ".xml";
            System.out.println(path);
            String fileContent = FileUtil.readFile(path);
            System.out.println(fileContent);
            JTextArea textArea = (JTextArea) tabbedPane.getSelectedComponent();
            textArea.append(fileContent + "\n");
            //TODO:调用执行非法
        } else {
            Vector children = nodeParent.getChildren();

            if (children != null) {
                for (Object obj : children) {
                    CheckBoxTreeNode node = (CheckBoxTreeNode) obj;
                    getNodePath(node, path);
                }
            }
        }
    }

    public void showXmlInfo(CheckBoxTreeNode nodeParent, String path) throws IOException {
        //获取被选中的节点
        path += (File.separator + nodeParent);
        if (nodeParent.isLeaf() && nodeParent.isSelected()) {
            //读取XML文件
            path = DemoMain.class.getClass().getResource("/").getPath() + path + File.separator + nodeParent + ".xml";
            System.out.println(path);
            String fileContent = FileUtil.readFile(path);
            System.out.println(fileContent);
            JTextArea textArea = (JTextArea) tabbedPane.getSelectedComponent();
            textArea.append(fileContent + "\n");
        } else {
            Vector children = nodeParent.getChildren();

            if (children != null) {
                for (Object obj : children) {
                    CheckBoxTreeNode node = (CheckBoxTreeNode) obj;
                    getNodePath(node, path);
                }
            }
        }
    }

    public void showXmlInfo(CheckBoxTreeNode nodeParent) throws IOException {
        JTextArea textArea = (JTextArea) tabbedPane.getComponent(0);
        textArea.setText("");
        showXmlInfo(rootNode, "");
    }


}
