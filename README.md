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

# To run Open WebUI With Docker
**On your computer:**
```
docker run -d -p 3000:8080 --add-host=host.docker.internal:host-gateway -v open-webui:/app/backend/data --name open-webui_ui_only --restart always ghcr.io/open-webui/open-webui:main
```
**On a Different Server:**
```
docker run -d -p 3000:8080 -e OLLAMA_BASE_URL=https://example.com -v open-webui:/app/backend/data --name open-webui --restart always ghcr.io/open-webui/open-webui:main
```
**With Nvidia GPU support:**
```
docker run -d -p 3000:8080 --gpus all --add-host=host.docker.internal:host-gateway -v open-webui:/app/backend/data --name open-webui --restart always ghcr.io/open-webui/open-webui:cuda
```

# To run Open WebUI with Bundled Ollama Support
**For CPU only:**
```
docker run -d -p 3000:8080 -v ollama:/root/.ollama -v open-webui:/app/backend/data --name open-webui --restart always ghcr.io/open-webui/open-webui:ollama
```
**With GPU Support:**
```
docker run -d -p 3000:8080 --gpus=all -v ollama:/root/.ollama -v open-webui:/app/backend/data --name open-webui --restart always ghcr.io/open-webui/open-webui:ollama
```
**To check Ollama Web UI is running:**
```
http://localhost:3000
```

# API Endpoint
**To check application status:**
```
Method: GET
Endpoint: http://localhost:8081/api/v1/ai/status
Response:
springai-ollama-demo is up and running!
```
**To call endpoint with JSON body:**
```
Method: POST
Endpoint: http://localhost:8081/api/v1/ai/generate
{
    "promptMessage": "Please identify the issue and fix; keep in mind that this is Java code. System.Out.prinlnln(\"APP IS RUNNING\");\n}"
}
```