/* Creating Rule Engine instance */
var R = new NodeRules();

/* Check if the engine blocks it!  fire() 函数名不可变 */
function fire(fact) {
    R.execute(fact, function (data) {
        jsbridge.setRuleResult(JSON.stringify(data));
    });
}