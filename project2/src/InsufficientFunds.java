/////////////////////////////////////////////
// File: InsufficientFunds.java
// Author: Justin Casey
// Date: June 6, 2019
// Purpose: This class creates the
//          insufficient funds exception
//          this exception is raised when
//          there are not enough funds in the acct
//

import javax.swing.JOptionPane;

public class InsufficientFunds extends Exception {

  public InsufficientFunds() {
    JOptionPane frame = new JOptionPane();
    JOptionPane.showMessageDialog(frame, "Insufficient Funds!");
  }
}
