//
//  LoginViewController.swift
//  LoginViperDemo
//
//  Created by Giang Béo  on 5/17/17.
//  Copyright © 2017 Atarshine. All rights reserved.
//

import UIKit

protocol LoginEventHandler {
    func login(userName : String?, password : String?)
}
class LoginViewController: UIViewController {

    @IBOutlet weak var userNameTextField: UITextField!
    @IBOutlet weak var passwordTextField: UITextField!
    
    var eventHandler : LoginEventHandler?

    override func viewDidLoad() {
        super.viewDidLoad()
        
        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

    @IBAction func clickLoginButton(sender: AnyObject) {
        
        eventHandler?.login(userName:userNameTextField.text, password: passwordTextField.text)
    }

}

