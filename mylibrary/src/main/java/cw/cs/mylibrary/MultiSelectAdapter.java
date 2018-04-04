package cw.cs.mylibrary;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cw.cs.mylibrary.node.MultiSelectNode;

/**
 * 多层节点adapter
 * 主要重写getItem与getItemCount实现成员隐藏功能
 */

public abstract class MultiSelectAdapter<T extends MultiSelectNode<T>> extends RecyclerView.Adapter {

    // 需要展示的最外层节点
    private final List<T> topGroups = new ArrayList<>();

    public void setData(T parent) {
        topGroups.clear();
        addData(parent);
    }

    public void setData(List<T> list) {
        topGroups.clear();
        addData(list);
    }

    public void addData(List<T> list) {
        if (list != null) {
            topGroups.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void addData(T parent) {
        if (parent != null) {
            topGroups.add(parent);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).getHierarchy();
    }

    @Override
    public int getItemCount() {
        return getTreeSize(topGroups);
    }

    /**
     * 获取指定位置的data
     *
     * @param position itemPosition
     * @return MultiSelectNode or null
     */
    public T getItem(int position) {
        int[] cur = {position};
        return getNode(topGroups, cur);
    }

    /**
     * 先序遍历 - 获取展示的总长度 （isExpand = true）
     *
     * @param nodes nodes
     * @return int
     */
    protected int getTreeSize(List<T> nodes) {
        int size = 0;
        for (T node : nodes) {
            size++;
            if (node.isExpand()) {
                size += getTreeSize(node.getChildren());
            }
        }
        return size;
    }


    /**
     * 先序遍历 - 获取指定位置的节点
     *
     * @param nodes    nodes
     * @param position itemPosition 数组只是为了实现手动box实现共享position
     * @return MultiSelectNode or null
     */
    protected T getNode(List<T> nodes, final int[] position) {
        for (T node : nodes) {
            if (position[0] == 0) {
                return node;
            }
            position[0]--;
            if (node.isExpand() && node.getChildren().size() > 0) {
                T finalNode = getNode(node.getChildren(), position);
                if (finalNode != null) {
                    return finalNode;
                }
            }
        }
        return null;
    }

}
