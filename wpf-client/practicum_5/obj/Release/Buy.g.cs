﻿#pragma checksum "..\..\Buy.xaml" "{8829d00f-11b8-4213-878b-770e8597ac16}" "10F3840A09029E881D56788EEEA62710C4B0648A4C632F904A2B1EE6C40FABCE"
//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.42000
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

using System;
using System.Diagnostics;
using System.Windows;
using System.Windows.Automation;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Ink;
using System.Windows.Input;
using System.Windows.Markup;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Media.Effects;
using System.Windows.Media.Imaging;
using System.Windows.Media.Media3D;
using System.Windows.Media.TextFormatting;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Windows.Shell;
using practicum_5;


namespace practicum_5 {
    
    
    /// <summary>
    /// Buy
    /// </summary>
    public partial class Buy : System.Windows.Window, System.Windows.Markup.IComponentConnector {
        
        
        #line 10 "..\..\Buy.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.ListBox InventoryBox;
        
        #line default
        #line hidden
        
        
        #line 11 "..\..\Buy.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.ListBox ProductBox;
        
        #line default
        #line hidden
        
        
        #line 18 "..\..\Buy.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Label BalanceLabel;
        
        #line default
        #line hidden
        
        private bool _contentLoaded;
        
        /// <summary>
        /// InitializeComponent
        /// </summary>
        [System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [System.CodeDom.Compiler.GeneratedCodeAttribute("PresentationBuildTasks", "4.0.0.0")]
        public void InitializeComponent() {
            if (_contentLoaded) {
                return;
            }
            _contentLoaded = true;
            System.Uri resourceLocater = new System.Uri("/practicum_5;component/buy.xaml", System.UriKind.Relative);
            
            #line 1 "..\..\Buy.xaml"
            System.Windows.Application.LoadComponent(this, resourceLocater);
            
            #line default
            #line hidden
        }
        
        [System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [System.CodeDom.Compiler.GeneratedCodeAttribute("PresentationBuildTasks", "4.0.0.0")]
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Never)]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Design", "CA1033:InterfaceMethodsShouldBeCallableByChildTypes")]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Maintainability", "CA1502:AvoidExcessiveComplexity")]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1800:DoNotCastUnnecessarily")]
        void System.Windows.Markup.IComponentConnector.Connect(int connectionId, object target) {
            switch (connectionId)
            {
            case 1:
            this.InventoryBox = ((System.Windows.Controls.ListBox)(target));
            
            #line 10 "..\..\Buy.xaml"
            this.InventoryBox.MouseDoubleClick += new System.Windows.Input.MouseButtonEventHandler(this.RemoveFromInventory);
            
            #line default
            #line hidden
            return;
            case 2:
            this.ProductBox = ((System.Windows.Controls.ListBox)(target));
            
            #line 11 "..\..\Buy.xaml"
            this.ProductBox.MouseDoubleClick += new System.Windows.Input.MouseButtonEventHandler(this.AddToInventory);
            
            #line default
            #line hidden
            return;
            case 3:
            
            #line 15 "..\..\Buy.xaml"
            ((System.Windows.Controls.Button)(target)).Click += new System.Windows.RoutedEventHandler(this.Click_Buy_Button);
            
            #line default
            #line hidden
            return;
            case 4:
            
            #line 16 "..\..\Buy.xaml"
            ((System.Windows.Controls.Button)(target)).Click += new System.Windows.RoutedEventHandler(this.Click_Refresh_Button);
            
            #line default
            #line hidden
            return;
            case 5:
            
            #line 17 "..\..\Buy.xaml"
            ((System.Windows.Controls.Button)(target)).Click += new System.Windows.RoutedEventHandler(this.To_Me);
            
            #line default
            #line hidden
            return;
            case 6:
            this.BalanceLabel = ((System.Windows.Controls.Label)(target));
            return;
            }
            this._contentLoaded = true;
        }
    }
}

