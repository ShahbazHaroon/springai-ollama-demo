# springai-ollama-demo

# Ollama
**To make environment variable:**
```
Variable: OLLAMA_MODELS
Value: C:\your_directory\models
```
**To check default model save path:**
```
Typically located at:
C:\Users\your_user\.ollama
```
**To check Ollama help:**
```
ollama help show
```
**To pull Ollama model:**
```
ollama pull llama2

For Uncensored version:
ollama pull llama2-uncensored:7b

For chat 7B model:
ollama pull llama2:7b-chat

For instruct model:
ollama pull mistral:instruct

For latest model:
ollama pull mistral:latest
```
**To pull and run Ollama model:**
```
ollama run llama2
```
**To check the list of pre-trained locally available models:**
```
ollama list
```
**To check which SHA file applies to a particular model:**
```
ollama show --modelfile llama2:7b
```
**To remove a model:**
```
ollama rm llama2:7b
```
**To start Ollama:**
```
ollama serve
```
**To check Ollama is running:**
```
http://localhost:11434
```
**To stop Ollama:**

Open Powershell and execute below command:
```
Get-Process | Where-Object {$_.ProcessName -like '*ollama*'} | Stop-Process
```
**For verbose model:**

ollama pull mistral --versbose

To programmatically pass in the contents of this file, we’re going to exit interactive mode and pass in the prompt directly. First up, summarising the article:
ollama run mistral --verbose "Please can you summarise this article: $(cat bbc.txt)"

I’d say it’s done a good job with that. How about if we ask for bullet points instead?
ollama run mistral --verbose "Can you pull out 5 bullet points from the following article: $(cat bbc.txt)"

Again, I like what it’s come up with. How about if we ask it to categorise the document and detect its sentiment?
ollama run mistral --verbose "If you had to categorise this article, what tags would you use?: $(cat bbc.txt)"

ollama run mistral --verbose "What's the sentiment of this article: $(cat bbc.txt)"
```
# API Endpoint
**To check application status:**
```
Method: GET
Endpoint: http://localhost:8081/api/v1/ai/status
Response:
springai-ollama-demo is up and running!
```
**To call endpoint with default Query Param: Why is the sky blue?**
```
Method: GET
Endpoint: http://localhost:8081/api/v1/ai/generate
Default Question: Why is the sky blue?
```
**To call endpoint with Query Param: tell the joke for engineer**
```
Method: GET
Endpoint: http://localhost:8081/api/v1/ai/generate
Query Param:
promptMessage: tell the joke for engineer
```
**To call endpoint with Path Variable: Write a short JD for Java Engineer**
```
Method: GET
Endpoint: http://localhost:8081/api/v1/ai/generate/{topic}
Path Variable:
Write a short JD for Java Engineer
```