/* File:    Rank.java
 * Created: 2017-02-08
 * Author:  Sabbir Manandhar
 *
 * Copyright (c) 2017 WorldLingo Inc.
 */

package com.worldlingo;

/**
 * TODO Insert Description of the Class
 *
 * @author Sabbir Manandhar
 * @version 1.0
 */
public class Rank {

  RankNode root;

  public void track(int data) {
    if (root == null) {
      root = new RankNode(data);
    } else {
      insert(root, data);
    }
  }

  private void insert(RankNode node, int data) {
    if (node.data < data) {
      if (node.rightChild == null) {
        node.rightChild = new RankNode(data);
      } else {
        insert(node.rightChild, data);
      }
    } else {
      node.childrenSize++;
      if (node.leftChild == null) {
        node.leftChild = new RankNode(data);
      } else {
        insert(node.leftChild, data);
      }
    }
  }

  public int getRank(int data) {
    return getRank(root, data);
  }

    public int getRank(RankNode node, int data) {
      if (node == null) {
        return -1;
      }

      if (node.data == data) {
        return node.childrenSize;
      } else if (node.data < data) {
        int childRank = getRank(node.rightChild, data);
        return childRank == -1 ? -1 : node.childrenSize + 1 + childRank;
      } else {
        return getRank(node.leftChild, data);
      }
    }

  public static void main(String[] args) {
    Rank rank = new Rank();
    rank.track(1);
    rank.track(1);
    int res = rank.getRank(1);
    rank.track(2);
    rank.track(10);
    rank.track(4);
    rank.track(3);
    rank.track(3);
    System.out.println("Rank of 1: " + res + " " + (res == 1));
    res = rank.getRank(10);
    System.out.println("Rank of 10: " + res + " " + (res == 6));
    res = rank.getRank(11);
    System.out.println("Rank of 11: " + res + " " + (res == -1));
    res = rank.getRank(3);
    System.out.println("Rank of 3: " + res + " " + (res == 4));
  }

} // Rank

class RankNode {
  int childrenSize = 0;
  int data;
  RankNode leftChild;
  RankNode rightChild;

  public RankNode(int data) {
    this.data = data;
  }
}
