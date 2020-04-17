package logic;

import javax.swing.JDialog;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import structure.Node;
import structure.Tree;

@SuppressWarnings("serial")
public class Logic extends JDialog{

	private DefaultTreeModel model;
	private DefaultMutableTreeNode rootGui;
	private JTree graficTree;
	private Tree tree;
	private Node<String> rootLogic;

	public Logic() {
		setSize(500,500);
		setLocationRelativeTo(null);
		init();
	}
	
	private void init() {
		rootLogic = new Node<String>("root123");
		tree = new Tree(new Node<String>("holaa"));
		rootGui = new DefaultMutableTreeNode("root");
		model = new DefaultTreeModel(rootGui);
		graficTree = new JTree(model);
		Node<String> a = new Node<String>("A");
		a.add(new Node<String>("Sub A1"));
		a.add(new Node<String>("Sub A2"));
		a.add(new Node<String>("Sub A3"));
		Node<String> b = new Node<String>("B");
		b.add(new Node<String>("Sub B1"));
		b.add(new Node<String>("Sub B2"));
		b.add(new Node<String>("Sub B3"));
		Node<String> b4 = new Node<String>("Sub B4");
		b.add(b4);
		b.add(new Node<String>("Sub B5"));
		b.add(new Node<String>("Sub B6"));
		Node<String> c = new Node<String>("C");
		rootLogic.add(a);
		rootLogic.add(b);
		rootLogic.add(c);
		printTree();
		add(graficTree);
		testSearch(b4);
	}

	public void printTree() {
		printTree(rootLogic, rootGui);
	}

	public void printTree(Node<String> info ,DefaultMutableTreeNode father) {
		DefaultMutableTreeNode child = new DefaultMutableTreeNode(info.getInfo());
		model.insertNodeInto(child, father, 0);
		for (Node<String> i : info.getList()) {
			printTree(i, child);
		}
	}
	
	public Node<String> searchTree(Node<String> info) {
		System.out.println("Estoy buscando : " + info.getInfo());
		return searchTree(rootLogic, info);
	}

	private Node<String> searchTree(Node<String> root, Node<String> info) {
		System.out.println(root.getInfo());
		if (root.getInfo().equals(info.getInfo())) {
			System.out.println("Entro al IF");
			return root;
		}
		for (Node<String> i : root.getList()) {
			searchTree(i, info);
		}
		return null;
	}
	
	public void testSearch(Node<String> info) {
		System.out.println(searchTree(info).getInfo());
	}


	public static void main(String[] args) {
		new Logic().setVisible(true);
	}

}
