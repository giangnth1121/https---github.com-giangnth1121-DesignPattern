//
//  ViewController.swift
//  VIPER
//
//  Created by  on 12/28/15.
//  Copyright © 2015 com.framgia. All rights reserved.
//

import UIKit

protocol LoginEventHandler {
    func login(_ userName : String?, password : String?)
}

class LoginViewController: UIViewController {

    var eventHandler : LoginEventHandler?
    @IBOutlet weak var userNameTextField: UITextField!
    @IBOutlet weak var passwordTextField: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    @IBAction func clickLoginButton(_ sender: AnyObject) {
        eventHandler?.login(userNameTextField.text, password: passwordTextField.text)
    }
    
}

