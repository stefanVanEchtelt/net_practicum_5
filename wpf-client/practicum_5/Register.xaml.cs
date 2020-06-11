using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Remoting;
using System.ServiceModel;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;
using practicum_5.CustomerServiceReference;

namespace practicum_5
{
    /// <summary>
    /// Interaction logic for Register.xaml
    /// </summary>
    public partial class Register : Window {

        public Register() {
            InitializeComponent();
        }

        private void Register_Button_Click(object sender, RoutedEventArgs e) {
            CustomerServiceClient CustomerServiceClient = new CustomerServiceClient();
            try
            {
                Customer newCustomer = CustomerServiceClient.RegisterCustomer(UsernameField.Text);
                password.Text = newCustomer.Password;
                MessageBox.Show("Vergeet niet het wachtwoord op te slaan!");
            }
            catch (FaultException<CustomerFaultService> exception)
            {
                MessageBox.Show(exception.Detail.Message);
                return;
            }
        }

        private void To_Login(object sender, RoutedEventArgs e) {
                Login LoginWindow = new Login();
                LoginWindow.Show();
                this.Close();
        }
    }
}
