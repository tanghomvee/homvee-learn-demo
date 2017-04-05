package demo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JTree;
import javax.swing.tree.TreePath;
import javax.swing.tree.DefaultTreeModel;

public class CheckBoxTreeNodeSelectionListener extends MouseAdapter {
    private ButtonAction buttonAction;

    @Override
    public void mouseClicked(MouseEvent event) {
        JTree tree = (JTree) event.getSource();
        int x = event.getX();
        int y = event.getY();
        int row = tree.getRowForLocation(x, y);
        TreePath path = tree.getPathForRow(row);
        if (path != null) {
            CheckBoxTreeNode node = (CheckBoxTreeNode) path.getLastPathComponent();
            if (node != null) {
                boolean isSelected = !node.isSelected();
                node.setSelected(isSelected);
                ((DefaultTreeModel) tree.getModel()).nodeStructureChanged(node);

                //如果叶子节点被选中 这显示XML信息
                try {
                    buttonAction.showXmlInfo(node);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public CheckBoxTreeNodeSelectionListener(ButtonAction buttonAction) {
        super();
        this.buttonAction = buttonAction;
    }


}
