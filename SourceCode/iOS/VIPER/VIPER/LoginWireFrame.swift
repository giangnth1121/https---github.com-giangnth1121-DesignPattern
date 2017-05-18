//
//  ShowWireFrame.swift
//  VIPER
//
//  Created by  on 12/28/15.
//  Copyright © 2015 com.framgia. All rights reserved.
//

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
        let successViewController = storyBoard.instantiateViewController(withIdentifier: "SuccessViewController")
            as! SuccessViewController
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
