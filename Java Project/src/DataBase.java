import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class Admin {
    public String userName;
    public String password;

    public Admin(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }


}
class Department {
    public int deptId;
    public String deptName;

    public Department(int deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    } 



}
class Grade {
    public int gradeId;
    public String gradeName;
    public int gradeBasic;
    public int gradeTravelAllowance;
    public int gradeHouseRentAllowance;
    public int gradeMedicalAllowance;
    public int gradeBonus;
    public int gradeProfessionalTax;

    public Grade(int gradeId, String gradeName, int gradeBasic, int gradeTravelAllowance,int gradeHouseRentAllowance, int gradeMedicalAllowance, int gradeBonus,int gradeProfessionalTax) {
        this.gradeId = gradeId;
        this.gradeName = gradeName;
        this.gradeBasic = gradeBasic;
        this.gradeTravelAllowance = gradeTravelAllowance;
       
        this.gradeHouseRentAllowance = gradeHouseRentAllowance;
        this.gradeMedicalAllowance = gradeMedicalAllowance;
        this.gradeBonus = gradeBonus;
       
        this.gradeProfessionalTax = gradeProfessionalTax;
    }


}

 class Employee {
    public int empId;
    public String empTitle;
    public String empName;
    public String empDateOfBirth;
    public String empDateOfJoining;
    public String empAddress;
    public String empMobileNo;
    public String empMailId;
 


    public Employee(int empId, String empTitle, String empName, String empDateOfBirth, String empDateOfJoining,
                    String empAddress, String empMobileNo, String empMailId) {
        this.empId = empId;
        this.empTitle = empTitle;
        this.empName = empName;
        this.empDateOfBirth = empDateOfBirth;
        this.empDateOfJoining = empDateOfJoining;
        this.empAddress = empAddress;
        this.empMobileNo = empMobileNo;
        this.empMailId = empMailId;
        
    }

  
}

class EmployeeGradeDetails {
    public int transactionId;
    public int empId;
    public int empDeptId;
    public int empGradeId;

    public EmployeeGradeDetails(int transactionId, int empId, int empDeptId, int empGradeId) {
        this.transactionId = transactionId;
        this.empId = empId;
        this.empDeptId = empDeptId;
        this.empGradeId = empGradeId;
    }

}
class EmployeeSalaryDetails {
    public int transactionId;
    public int empId;
    public String empSalaryMonth;
    public int empGradeId;
    public int empBasic;
    public int empTravelAllowance;
    public int empHouseRentAllowance;
    public int empMedicalAllowance;
    public int empBonus;
    public int empProfessionalTax;
    public int empGrossSalary;
    public int empTotalSalary;

    



    public EmployeeSalaryDetails(int transactionId, int empId, String empSalaryMonth, int empGradeId, int empBasic, int empTravelAllowance, int empHouseRentAllowance, int empMedicalAllowance, int empBonus, int empProfessionalTax, int empGrossSalary, int empTotalSalary) {
        this.transactionId = transactionId;
        this.empId = empId;
        this.empSalaryMonth = empSalaryMonth;
        this.empGradeId = empGradeId;
        this.empBasic = empBasic;
        this.empTravelAllowance = empTravelAllowance;
        this.empHouseRentAllowance = empHouseRentAllowance;
        this.empMedicalAllowance = empMedicalAllowance;
        this.empBonus = empBonus;
        this.empProfessionalTax = empProfessionalTax;
        this.empGrossSalary = empGrossSalary;
        this.empTotalSalary = empTotalSalary;
    }
}

class Role {
    private int roleId;
    private String roleTitle;
    private double roleBaseSalary;

    public Role(int roleId, String roleTitle, double roleBaseSalary) {
        this.roleId = roleId;
        this.roleTitle = roleTitle;
        this.roleBaseSalary = roleBaseSalary;
    }
}

class AdminQueries {
    public static String URL = "jdbc:mysql://localhost:3306/login_system";
    public static  String USERNAME = "root";
    public static  String PASSWORD = "mynameis12345@";

    public static boolean isAdminValid(String userName, String password) {
        boolean valid = false;

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sqlQuery = "SELECT * FROM Admins WHERE UserName = ? AND Password = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setString(1, userName);
                preparedStatement.setString(2, password);

                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {  // Check if there is at least one row
                    valid = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return valid;
    }

    
    public static boolean isUserNameExists(String userName) {
        boolean exists = false;

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sqlQuery = "SELECT COUNT(*) FROM Admins WHERE UserName = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setString(1, userName);

                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();
                int count = resultSet.getInt(1);
                exists = count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }

    public static boolean isPasswordCorrect(String userName, String password) {
        boolean correct = false;

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sqlQuery = "SELECT COUNT(*) FROM Admins WHERE UserName = ? AND Password = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setString(1, userName);
                preparedStatement.setString(2, password);

                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();
                int count = resultSet.getInt(1);
                correct = count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return correct;
    }
}



class DepartmentQueries {
    public static String url = "jdbc:mysql://localhost:3306/payroll_management_system";
    public static String userName = "root";
    public static String password = "mynameis12345@";

    public static Department insertDepartment(int deptId, String deptName) {
        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            String sqlQuery = "INSERT INTO Department (dept_id, dept_name) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery, PreparedStatement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setInt(1, deptId);
                preparedStatement.setString(2, deptName);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Department inserted successfully.");
                    ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        int generatedDeptId = generatedKeys.getInt(1);
                        return new Department(generatedDeptId, deptName);
                    }
                } else {
                    System.out.println("Failed to insert department.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static boolean updateDepartment(int deptId, String newDeptName) {
        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            String sqlQuery = "UPDATE Department SET dept_name = ? WHERE dept_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setString(1, newDeptName);
                preparedStatement.setInt(2, deptId);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Department updated successfully.");
                    return true;
                } else {
                    System.out.println("Failed to update department.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteDepartment(int deptId) {
        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            String sqlQuery = "DELETE FROM Department WHERE dept_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setInt(1, deptId);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Department deleted successfully.");
                    return true;
                } else {
                    System.out.println("Failed to delete department.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean alterDepartmentTable(String newColumnName) {
        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            String sqlQuery = "ALTER TABLE Department ADD COLUMN ? VARCHAR(100)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setString(1, newColumnName);
                boolean result = preparedStatement.execute();
                if (!result) {
                    System.out.println("Table altered successfully.");
                    return true;
                } else {
                    System.out.println("Failed to alter table.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Department selectDepartment(int deptId) {
        Department department = null;
        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            String sqlQuery = "SELECT * FROM Department WHERE dept_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setInt(1, deptId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String deptName = resultSet.getString("dept_name");
                    department = new Department(deptId, deptName);
                } else {
                    System.out.println("Department not found.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;
    }

    public static List<Department> selectAllDepartments() {
        List<Department> departments = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            String sqlQuery = "SELECT * FROM Department";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int deptId = resultSet.getInt("dept_id");
                    String deptName = resultSet.getString("dept_name");
                    departments.add(new Department(deptId, deptName));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departments;
    }

}



class GradeQueries {
    public static String url = "jdbc:mysql://localhost:3306/payroll_management_system";
    public static String userName = "root";
    public static String password = "mynameis12345@";

    public static boolean insertGrade(int gradeId, String gradeName, int gradeBasic, int gradeTravelAllowance,
    int gradeHouseRentAllowance, int gradeMedicalAllowance, int gradeProfessionalTax) {
try (Connection connection = DriverManager.getConnection(url, userName, password)) {
String sqlQuery = "INSERT INTO Grade (grade_id, grade_name, grade_basic, grade_travel_allowance, " +
"grade_house_rent_allowance, grade_medical_allowance, grade_professional_tax) VALUES (?, ?, ?, ?, ?, ?, ?)";
try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery, new String[]{"grade_id"})) {
preparedStatement.setInt(1, gradeId);
preparedStatement.setString(2, gradeName);
preparedStatement.setInt(3, gradeBasic);
preparedStatement.setInt(4, gradeTravelAllowance);
preparedStatement.setInt(5, gradeHouseRentAllowance);
preparedStatement.setInt(6, gradeMedicalAllowance);
preparedStatement.setInt(7, gradeProfessionalTax);
int rowsAffected = preparedStatement.executeUpdate();
if (rowsAffected > 0) {
System.out.println("Grade inserted successfully.");
return true;
} else {
System.out.println("Failed to insert grade.");
}
}
} catch (SQLException e) {
e.printStackTrace();
}
return false;
}


    public static boolean updateGrade(int gradeId, String gradeName, int gradeBasic, int gradeTravelAllowance,
                                      int gradeHouseRentAllowance, int gradeMedicalAllowance,
                                      int gradeBonus, int gradeProfessionalTax) {
        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            String sqlQuery = "UPDATE Grade SET grade_name = ?, grade_basic = ?, grade_travel_allowance = ?, " +
                    "grade_house_rent_allowance = ?, grade_medical_allowance = ?, " +
                    "grade_bonus = ?, grade_professional_tax = ? WHERE grade_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setString(1, gradeName);
                preparedStatement.setInt(2, gradeBasic);
                preparedStatement.setInt(3, gradeTravelAllowance);
                preparedStatement.setInt(4, gradeHouseRentAllowance);
                preparedStatement.setInt(5, gradeMedicalAllowance);
                preparedStatement.setInt(6, gradeBonus);
                preparedStatement.setInt(7, gradeProfessionalTax);
                preparedStatement.setInt(8, gradeId);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Grade updated successfully.");
                    return true;
                } else {
                    System.out.println("Failed to update grade.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteGrade(int gradeId) {
        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            String sqlQuery = "DELETE FROM Grade WHERE grade_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setInt(1, gradeId);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Grade deleted successfully.");
                    return true;
                } else {
                    System.out.println("Failed to delete grade.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Grade selectGrade(int gradeId) {
        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            String sqlQuery = "SELECT * FROM Grade WHERE grade_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setInt(1, gradeId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    int gradeBasic = resultSet.getInt("grade_basic");
                    int gradeTravelAllowance = resultSet.getInt("grade_travel_allowance");
                    int gradeHouseRentAllowance = resultSet.getInt("grade_house_rent_allowance");
                    int gradeMedicalAllowance = resultSet.getInt("grade_medical_allowance");
                    int gradeBonus = resultSet.getInt("grade_bonus");
                    int gradeProfessionalTax = resultSet.getInt("grade_professional_tax");
                    return new Grade(gradeId, resultSet.getString("grade_name"), gradeBasic, gradeTravelAllowance,
                            gradeHouseRentAllowance, gradeMedicalAllowance,
                            gradeBonus, gradeProfessionalTax);
                } else {
                    System.out.println("Grade not found.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean alterGradeTable(String newColumnName, String columnType) {
        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            String sqlQuery = "ALTER TABLE Grade ADD COLUMN " + newColumnName + " " + columnType;
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                boolean result = preparedStatement.execute();
                if (!result) {
                    System.out.println("Table altered successfully.");
                    return true;
                } else {
                    System.out.println("Failed to alter table.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}



class EmployeeQueries {
    public static String url = "jdbc:mysql://localhost:3306/payroll_management_system";
    public static String userName = "root";
    public static String password = "mynameis12345@";

    public static boolean insertEmployee(int empId, String empTitle, String empName, String empDateOfBirth,
                                     String empDateOfJoining, String empAddress, String empMobileNo,
                                     String empMailId) {
    try (Connection connection = DriverManager.getConnection(url, userName, password)) {
        String sqlQuery = "INSERT INTO Employee (emp_id, emp_title, emp_name, emp_date_of_birth, " +
                "emp_date_of_joining, emp_address, emp_mobile_no, emp_mail_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, empId);
            preparedStatement.setString(2, empTitle);
            preparedStatement.setString(3, empName);
            preparedStatement.setString(4, empDateOfBirth);
            preparedStatement.setString(5, empDateOfJoining);
            preparedStatement.setString(6, empAddress);
            preparedStatement.setString(7, empMobileNo);
            preparedStatement.setString(8, empMailId);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Employee inserted successfully.");
                return true;
            } else {
                System.out.println("Failed to insert employee.");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}


    public static boolean updateEmployee(int empId, String empTitle, String empName, String empDateOfBirth,
                                         String empDateOfJoining, String empAddress, String empMobileNo,
                                         String empMailId, int roleId) {
        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            String sqlQuery = "UPDATE Employee SET emp_title = ?, emp_name = ?, emp_date_of_birth = ?, " +
                    "emp_date_of_joining = ?, emp_address = ?, emp_mobile_no = ?, emp_mail_id = ?, role_id = ? " +
                    "WHERE emp_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setString(1, empTitle);
                preparedStatement.setString(2, empName);
                preparedStatement.setString(3, empDateOfBirth);
                preparedStatement.setString(4, empDateOfJoining);
                preparedStatement.setString(5, empAddress);
                preparedStatement.setString(6, empMobileNo);
                preparedStatement.setString(7, empMailId);
                preparedStatement.setInt(8, roleId);
                preparedStatement.setInt(9, empId);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Employee updated successfully.");
                    return true;
                } else {
                    System.out.println("Failed to update employee.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteEmployee(int empId) {
        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            String sqlQuery = "DELETE FROM Employee WHERE emp_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setInt(1, empId);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Employee deleted successfully.");
                    return true;
                } else {
                    System.out.println("Failed to delete employee.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Employee selectEmployee(int empId) {
        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            String sqlQuery = "SELECT * FROM Employee WHERE emp_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setInt(1, empId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String empTitle = resultSet.getString("emp_title");
                    String empName = resultSet.getString("emp_name");
                    String empDateOfBirth = resultSet.getString("emp_date_of_birth");
                    String empDateOfJoining = resultSet.getString("emp_date_of_joining");
                    String empAddress = resultSet.getString("emp_address");
                    String empMobileNo = resultSet.getString("emp_mobile_no");
                    String empMailId = resultSet.getString("emp_mail_id");
                
                    return new Employee(empId, empTitle, empName, empDateOfBirth, empDateOfJoining,
                            empAddress, empMobileNo, empMailId);
                } else {
                    System.out.println("Employee not found.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean alterEmployeeTable(String newColumnName, String columnType) {
        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            String sqlQuery = "ALTER TABLE Employee ADD COLUMN " + newColumnName + " " + columnType;
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                boolean result = preparedStatement.execute();
                if (!result) {
                    System.out.println("Table altered successfully.");
                    return true;
                } else {
                    System.out.println("Failed to alter table.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}



class EmployeeGradeDetailsQueries {
    private static String url = "jdbc:mysql://localhost:3306/payroll_management_system";
    private static String userName = "root";
    private static String password = "mynameis12345@";

    public static boolean insertEmployeeGradeDetails(int transactionId, int empId, int empDeptId, int empGradeId) {
        boolean isInserted = false;
        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            String sqlQuery = "INSERT INTO Employee_Grade_Detail (transaction_id, emp_id, emp_dept_id, emp_grade_id) " +
                              "VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setInt(1, transactionId);
                preparedStatement.setInt(2, empId);
                preparedStatement.setInt(3, empDeptId);
                preparedStatement.setInt(4, empGradeId);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("EmployeeGradeDetails inserted successfully.");
                    isInserted = true;
                } else {
                    System.out.println("Failed to insert EmployeeGradeDetails.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isInserted;
    }
    


    public static boolean updateEmployeeGradeDetails(int transactionId, int empId, int empDeptId, int empGradeId) {
        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            String sqlQuery = "UPDATE EmployeeGradeDetail SET emp_id = ?, emp_dept_id = ?, emp_grade_id = ? " +
                              "WHERE transaction_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setInt(1, empId);
                preparedStatement.setInt(2, empDeptId);
                preparedStatement.setInt(3, empGradeId);
                preparedStatement.setInt(4, transactionId);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("EmployeeGradeDetails updated successfully.");
                    return true;
                } else {
                    System.out.println("Failed to update EmployeeGradeDetails.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteEmployeeGradeDetails(int transactionId) {
        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            String sqlQuery = "DELETE FROM EmployeeGradeDetail WHERE transaction_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setInt(1, transactionId);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("EmployeeGradeDetails deleted successfully.");
                    return true;
                } else {
                    System.out.println("Failed to delete EmployeeGradeDetails.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static EmployeeGradeDetails selectEmployeeGradeDetails(int transactionId) {
        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            String sqlQuery = "SELECT * FROM Employee_Grade_Detail WHERE emp_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setInt(1, transactionId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    int empId = resultSet.getInt("emp_id");
                    int empDeptId = resultSet.getInt("emp_dept_id");
                    int empGradeId = resultSet.getInt("emp_grade_id");
                    return new EmployeeGradeDetails(transactionId, empId, empDeptId, empGradeId);
                } else {
                    System.out.println("EmployeeGradeDetails not found.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}


class EmployeeSalaryDetailsQueries {
    private static String url = "jdbc:mysql://localhost:3306/payroll_management_system";
    private static String userName = "root";
    private static String password = "mynameis12345@";

    public static boolean insertEmployeeSalaryDetails(int transactionId, int empId, String empSalaryMonth, int empDeptId, int empGradeId, int empBasic, int empTravelAllowance, int empHouseRentAllowance, int empMedicalAllowance, int empBonus, int empProfessionalTax, int empGrossSalary, int empTotalSalary) {
        boolean isInserted = false;
        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            String sqlQuery = "INSERT INTO EmployeeSalaryDetails (transaction_id, emp_id, emp_salary_month, emp_dept_id, emp_grade_id, emp_basic, emp_travel_allowance, emp_house_rent_allowance, emp_medical_allowance, emp_bonus, emp_professional_tax, emp_gross_salary, emp_total_salary) " +
                              "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setInt(1, transactionId);
                preparedStatement.setInt(2, empId);
                preparedStatement.setString(3, empSalaryMonth);
                preparedStatement.setInt(4, empDeptId);
                preparedStatement.setInt(5, empGradeId);
                preparedStatement.setInt(6, empBasic);
                preparedStatement.setInt(7, empTravelAllowance);
                preparedStatement.setInt(8, empHouseRentAllowance);
                preparedStatement.setInt(9, empMedicalAllowance);
                preparedStatement.setInt(10, empBonus);
                preparedStatement.setInt(11, empProfessionalTax);
                preparedStatement.setInt(12, empGrossSalary);
                preparedStatement.setInt(13, empTotalSalary);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("EmployeeSalaryDetails inserted successfully.");
                    isInserted = true;
                } else {
                    System.out.println("Failed to insert EmployeeSalaryDetails.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isInserted;
    }
    

    public static boolean updateEmployeeSalaryDetails(int transactionId, int empId, String empSalaryMonth, int empDeptId, int empGradeId, int empBasic, int empTravelAllowance, int empHouseRentAllowance, int empMedicalAllowance, int empBonus, int empProfessionalTax, int empGrossSalary, int empTotalSalary) {
        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            String sqlQuery = "UPDATE EmployeeSalaryDetails SET emp_id = ?, emp_salary_month = ?, emp_dept_id = ?, emp_grade_id = ?, emp_basic = ?, emp_travel_allowance = ?, emp_house_rent_allowance = ?, emp_medical_allowance = ?, emp_bonus = ?, emp_professional_tax = ?, emp_gross_salary = ?, emp_total_salary = ? " +
                              "WHERE transaction_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setInt(1, empId);
                preparedStatement.setString(2, empSalaryMonth);
                preparedStatement.setInt(3, empDeptId);
                preparedStatement.setInt(4, empGradeId);
                preparedStatement.setInt(5, empBasic);
                preparedStatement.setInt(6, empTravelAllowance);
                preparedStatement.setInt(7, empHouseRentAllowance);
                preparedStatement.setInt(8, empMedicalAllowance);
                preparedStatement.setInt(9, empBonus);
                preparedStatement.setInt(10, empProfessionalTax);
                preparedStatement.setInt(11, empGrossSalary);
                preparedStatement.setInt(12, empTotalSalary);
                preparedStatement.setInt(13, transactionId);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("EmployeeSalaryDetails updated successfully.");
                    return true;
                } else {
                    System.out.println("Failed to update EmployeeSalaryDetails.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteEmployeeSalaryDetails(int transactionId) {
        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            String sqlQuery = "DELETE FROM EmployeeSalaryDetails WHERE transaction_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setInt(1, transactionId);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("EmployeeSalaryDetails deleted successfully.");
                    return true;
                } else {
                    System.out.println("Failed to delete EmployeeSalaryDetails.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static EmployeeSalaryDetails selectEmployeeSalaryDetails(int transactionId) {
        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            String sqlQuery = "SELECT * FROM Employee_Salary_Details WHERE transaction_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setInt(1, transactionId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    int empId = resultSet.getInt("emp_id");
                    String empSalaryMonth = resultSet.getString("emp_salary_month");
                    int empGradeId = resultSet.getInt("emp_grade_id");
                    int empBasic = resultSet.getInt("emp_basic");
                    int empTravelAllowance = resultSet.getInt("emp_travel_allowance");
                    int empHouseRentAllowance = resultSet.getInt("emp_house_rent_allowance");
                    int empMedicalAllowance = resultSet.getInt("emp_medical_allowance");
                    int empBonus = resultSet.getInt("emp_bonus");
                    int empProfessionalTax = resultSet.getInt("emp_professional_tax");
                    int empGrossSalary = resultSet.getInt("emp_gross_salary");
                    int empTotalSalary = resultSet.getInt("emp_total_salary");
                    return new EmployeeSalaryDetails(transactionId, empId, empSalaryMonth, empGradeId, empBasic, empTravelAllowance, empHouseRentAllowance, empMedicalAllowance, empBonus, empProfessionalTax, empGrossSalary, empTotalSalary);
                } else {
                    System.out.println("EmployeeSalaryDetails not found.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

class RoleQueries {
    private static String url = "jdbc:mysql://localhost:3306/payroll_management_system";
    private static String userName = "root";
    private static String password = "mynameis12345@";

    public static void insertRole(int roleId, String roleTitle, double roleBaseSalary) {
        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            String sqlQuery = "INSERT INTO Role (role_id, role_title, role_base_salary) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setInt(1, roleId);
                preparedStatement.setString(2, roleTitle);
                preparedStatement.setDouble(3, roleBaseSalary);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Role inserted successfully.");
                   
                } else {
                    System.out.println("Failed to insert Role.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
    }

    public static boolean updateRole(int roleId, String roleTitle, double roleBaseSalary) {
        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            String sqlQuery = "UPDATE Role SET role_title = ?, role_base_salary = ? WHERE role_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setString(1, roleTitle);
                preparedStatement.setDouble(2, roleBaseSalary);
                preparedStatement.setInt(3, roleId);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Role updated successfully.");
                    return true;
                } else {
                    System.out.println("Failed to update Role.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteRole(int roleId) {
        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            String sqlQuery = "DELETE FROM Role WHERE role_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setInt(1, roleId);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Role deleted successfully.");
                    return true;
                } else {
                    System.out.println("Failed to delete Role.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Role selectRole(int roleId) {
        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            String sqlQuery = "SELECT * FROM Role WHERE role_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setInt(1, roleId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String roleTitle = resultSet.getString("role_title");
                    double roleBaseSalary = resultSet.getDouble("role_base_salary");
                    return new Role(roleId, roleTitle, roleBaseSalary);
                } else {
                    System.out.println("Role not found.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}


public class DataBase {
   public static void main(String[] args) {
    // Provide the employee ID you want to search for
    int transactionId = 6; // Provide a valid transaction ID for testing

    // Call the method and store the result
    EmployeeSalaryDetails salaryDetails = EmployeeSalaryDetailsQueries.selectEmployeeSalaryDetails(transactionId);

    // Check if details are retrieved successfully
    if (salaryDetails != null) {
        // Print the retrieved details
        System.out.println("Employee Salary Details:");
        System.out.println("Transaction ID: " + salaryDetails.transactionId);
        System.out.println("Employee ID: " + salaryDetails.empId);
        System.out.println("Salary Month: " + salaryDetails.empSalaryMonth);
        System.out.println("Grade ID: " + salaryDetails.empGradeId);
        System.out.println("Basic Salary: " + salaryDetails.empBasic);
        System.out.println("Travel Allowance: " + salaryDetails.empTravelAllowance);
        System.out.println("House Rent Allowance: " + salaryDetails.empHouseRentAllowance);
        System.out.println("Medical Allowance: " + salaryDetails.empMedicalAllowance);
        System.out.println("Bonus: " + salaryDetails.empBonus);
        System.out.println("Professional Tax: " + salaryDetails.empProfessionalTax);
        System.out.println("Gross Salary: " + salaryDetails.empGrossSalary);
        System.out.println("Total Salary: " + salaryDetails.empTotalSalary);
    } else {
        System.out.println("Employee Salary Details not found.");
    }
    
   }
}
