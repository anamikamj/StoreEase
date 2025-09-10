import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card";
import { Button } from "@/components/ui/button";
import { ArrowRight, UserCheck, ShoppingBag, Package2, BarChart } from "lucide-react";

const HowItWorks = () => {
  const userSteps = [
    {
      icon: UserCheck,
      title: "Sign Up & Login",
      description: "Create your student account or login with existing credentials to access the store",
      step: "01"
    },
    {
      icon: ShoppingBag,
      title: "Browse & Shop",
      description: "Explore categories, search items, check availability, and add to your cart",
      step: "02"
    },
    {
      icon: Package2,
      title: "Checkout & Pay",
      description: "Complete secure online payment and track your order status",
      step: "03"
    }
  ];

  const managerSteps = [
    {
      icon: Package2,
      title: "Manage Inventory",
      description: "Add new items, update stock levels, set prices, and organize categories",
      step: "01"
    },
    {
      icon: BarChart,
      title: "Monitor & Analyze",
      description: "Track sales, monitor stock levels, and receive automated alerts",
      step: "02"
    },
    {
      icon: UserCheck,
      title: "Process Orders",
      description: "Handle customer orders, manage payments, and update store settings",
      step: "03"
    }
  ];

  return (
    <section id="how-it-works" className="py-20 bg-background">
      <div className="container px-4">
        <div className="text-center mb-16">
          <h2 className="text-3xl md:text-4xl font-bold text-foreground mb-4">
            How StoreEase Works
          </h2>
          <p className="text-lg text-muted-foreground max-w-2xl mx-auto">
            Simple, intuitive workflows designed for both shoppers and store managers
          </p>
        </div>

        <div className="grid lg:grid-cols-2 gap-12">
          {/* User Journey */}
          <div className="space-y-8">
            <div className="text-center lg:text-left">
              <h3 className="text-2xl font-bold text-primary mb-4">For Students & Staff</h3>
              <p className="text-muted-foreground">Simple shopping experience in three easy steps</p>
            </div>
            
            <div className="space-y-6">
              {userSteps.map((step, index) => (
                <Card key={index} className="relative overflow-hidden bg-card-gradient shadow-card hover:shadow-feature transition-all duration-300">
                  <CardHeader className="pb-4">
                    <div className="flex items-center space-x-4">
                      <div className="flex-shrink-0">
                        <div className="h-12 w-12 rounded-full bg-hero-gradient flex items-center justify-center">
                          <step.icon className="h-6 w-6 text-white" />
                        </div>
                      </div>
                      <div className="flex-1">
                        <div className="flex items-center space-x-3">
                          <span className="text-xs font-bold text-primary bg-primary/10 px-2 py-1 rounded-full">
                            STEP {step.step}
                          </span>
                        </div>
                        <CardTitle className="text-lg mt-2">{step.title}</CardTitle>
                      </div>
                    </div>
                  </CardHeader>
                  <CardContent>
                    <CardDescription className="text-sm leading-relaxed">
                      {step.description}
                    </CardDescription>
                  </CardContent>
                  {index < userSteps.length - 1 && (
                    <div className="absolute -bottom-3 left-6 h-6 w-6 bg-primary/20 rounded-full flex items-center justify-center">
                      <ArrowRight className="h-3 w-3 text-primary rotate-90" />
                    </div>
                  )}
                </Card>
              ))}
            </div>

            <Button className="w-full bg-hero-gradient hover:opacity-90 shadow-elegant">
              Start Shopping Now
              <ArrowRight className="h-4 w-4 ml-2" />
            </Button>
          </div>

          {/* Manager Journey */}
          <div className="space-y-8">
            <div className="text-center lg:text-left">
              <h3 className="text-2xl font-bold text-primary mb-4">For Store Managers</h3>
              <p className="text-muted-foreground">Efficient inventory management workflow</p>
            </div>
            
            <div className="space-y-6">
              {managerSteps.map((step, index) => (
                <Card key={index} className="relative overflow-hidden bg-card-gradient shadow-card hover:shadow-feature transition-all duration-300">
                  <CardHeader className="pb-4">
                    <div className="flex items-center space-x-4">
                      <div className="flex-shrink-0">
                        <div className="h-12 w-12 rounded-full bg-gradient-to-br from-accent to-accent/80 flex items-center justify-center">
                          <step.icon className="h-6 w-6 text-white" />
                        </div>
                      </div>
                      <div className="flex-1">
                        <div className="flex items-center space-x-3">
                          <span className="text-xs font-bold text-accent bg-accent/10 px-2 py-1 rounded-full">
                            STEP {step.step}
                          </span>
                        </div>
                        <CardTitle className="text-lg mt-2">{step.title}</CardTitle>
                      </div>
                    </div>
                  </CardHeader>
                  <CardContent>
                    <CardDescription className="text-sm leading-relaxed">
                      {step.description}
                    </CardDescription>
                  </CardContent>
                  {index < managerSteps.length - 1 && (
                    <div className="absolute -bottom-3 left-6 h-6 w-6 bg-accent/20 rounded-full flex items-center justify-center">
                      <ArrowRight className="h-3 w-3 text-accent rotate-90" />
                    </div>
                  )}
                </Card>
              ))}
            </div>

            <Button variant="outline" className="w-full border-accent text-accent hover:bg-accent/5">
              Access Manager Dashboard
              <ArrowRight className="h-4 w-4 ml-2" />
            </Button>
          </div>
        </div>
      </div>
    </section>
  );
};

export default HowItWorks;