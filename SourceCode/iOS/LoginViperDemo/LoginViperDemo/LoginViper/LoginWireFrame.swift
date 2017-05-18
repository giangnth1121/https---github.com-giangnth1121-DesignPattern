//
//  LoginWireFrame.swift
//  LoginViperDemo
//
//  Created by Giang Béo  on 5/17/17.
//  Copyright © 2017 Atarshine. All rights reserved.
//

import Foundation
import UIKit

class LoginWireFrame: NSObject {
    
    var loginViewController : LoginViewController?
    
    class var sharedInstance : LoginWireFrame {
        struct Static {
            static let instance : LoginWireFrame = LoginWireFrame()
        }
        return Static.instance
    }
    
    func presentLoginViewControllerFromWindow(_ window : UIWindow) {
        // create LoginViewController instance
        let storyBoard = UIStoryboard(name: "Main", bundle: Bundle.main)
        let loginVC = storyBoard.instantiateViewController(withIdentifier: "LoginViewController")
            as! LoginViewController
        
        // create presenter && interactor
        let loginPresenter = LoginPresenter()
        let loginInteractor = LoginInteractor()
        loginPresenter.input = loginInteractor
        loginPresenter.loginVC = loginViewController
        loginInteractor.output = loginPresenter
        
        // set event handler for loginViewController
        loginVC.eventHandler = loginPresenter
        self.loginViewController = loginVC
        let navController = UINavigationController(rootViewController: self.loginViewController!)
        window.rootViewController = navController
    }
    
    func presentSuccessViewController() {
        let storyBoard = UIStoryboard(name: "Main", bundle: Bundle.main)
        let successViewController = storyBoard.instantiateViewController(withIdentifier: "LoginSuccessViewController")
            as! LoginSuccessViewController
        DispatchQueue.main.async { () -> Void in
            self.loginViewController?.navigationController?.pushViewController(
                successViewController,
                animated: true
            )
        }
    }
    
    func presentAlertForLoginView(_ message : String) {
        // show alert
        let alertViewController = UIAlertController(
            title: "Login Failed",
            message: message,
            preferredStyle: .alert
        )
        
        let okAction = UIAlertAction(
            title: "OK",
            style: .cancel,
            handler: { (action : UIAlertAction) -> Void in
                print("OK")
        })
        
        alertViewController.addAction(okAction)
        loginViewController?.present(alertViewController, animated: true, completion: nil)
    }
    
}
