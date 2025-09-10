import { useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card";
import { Button } from "@/components/ui/button";
import { LogOut, CheckCircle } from "lucide-react";
import { useToast } from "@/hooks/use-toast";

const Logout = () => {
  const navigate = useNavigate();
  const { toast } = useToast();

  useEffect(() => {
    // Simulate logout process
    const timer = setTimeout(() => {
      toast({
        title: "Logged out successfully",
        description: "You have been securely logged out of your account",
      });
      navigate("/");
    }, 2000);

    return () => clearTimeout(timer);
  }, [navigate, toast]);

  return (
    <div className="min-h-screen bg-hero-gradient-light flex items-center justify-center p-4">
      <div className="w-full max-w-md">
        <Card className="shadow-elegant text-center">
          <CardHeader className="pb-4">
            <div className="h-16 w-16 rounded-full bg-green-100 flex items-center justify-center mx-auto mb-4">
              <CheckCircle className="h-8 w-8 text-green-600" />
            </div>
            <CardTitle className="text-2xl">Logging Out...</CardTitle>
            <CardDescription>
              Please wait while we securely log you out of your account
            </CardDescription>
          </CardHeader>
          <CardContent className="space-y-6">
            <div className="space-y-4">
              <div className="flex items-center justify-center space-x-2 text-sm text-muted-foreground">
                <div className="h-2 w-2 bg-primary rounded-full animate-pulse"></div>
                <span>Clearing session data</span>
              </div>
              <div className="flex items-center justify-center space-x-2 text-sm text-muted-foreground">
                <div className="h-2 w-2 bg-primary rounded-full animate-pulse" style={{ animationDelay: "0.5s" }}></div>
                <span>Securing your account</span>
              </div>
              <div className="flex items-center justify-center space-x-2 text-sm text-muted-foreground">
                <div className="h-2 w-2 bg-primary rounded-full animate-pulse" style={{ animationDelay: "1s" }}></div>
                <span>Redirecting to home page</span>
              </div>
            </div>

            <div className="pt-4 border-t">
              <p className="text-sm text-muted-foreground mb-4">
                Thank you for using StoreEase!
              </p>
              <Button 
                variant="outline" 
                onClick={() => navigate("/")}
                className="w-full"
              >
                Return to Home Page
              </Button>
            </div>

            <div className="text-xs text-muted-foreground">
              <p>If you're not redirected automatically,</p>
              <button 
                onClick={() => navigate("/")}
                className="text-primary hover:underline"
              >
                click here to return to the home page
              </button>
            </div>
          </CardContent>
        </Card>

        {/* Quick Actions */}
        <div className="mt-6 text-center space-y-2">
          <p className="text-sm text-muted-foreground">Want to continue shopping?</p>
          <div className="flex space-x-2 justify-center">
            <Button 
              variant="outline" 
              size="sm"
              onClick={() => navigate("/login")}
            >
              <LogOut className="h-4 w-4 mr-2" />
              Login Again
            </Button>
            <Button 
              variant="outline" 
              size="sm"
              onClick={() => navigate("/store")}
            >
              Browse Store
            </Button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Logout;